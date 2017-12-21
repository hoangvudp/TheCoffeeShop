package mum.waa.coffee.service.impl;

import mum.waa.coffee.domain.Authority;
import mum.waa.coffee.domain.Member;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.repository.MemberRepository;
import mum.waa.coffee.service.MemberService;
import mum.waa.coffee.service.UserCredentialsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
    private MemberRepository memberRepository;
    
 	@Autowired
 	UserCredentialsService credentialsService;

    public List<Member> getAllMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Member saveMember(Member member) throws EmailTakenException, UsernameTakenException {
    		validateMember(member);
    	
  		credentialsService.save(member.getUserCredentials());
  		return memberRepository.save(member);
    }

    public List<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Member findById(Long id) {
        return memberRepository.findOne(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeMember(Member member) {
        memberRepository.delete(member);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void removeMember(Long id) {
        memberRepository.delete(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Member registerNewMember(Member member) throws EmailTakenException, UsernameTakenException {
    		String username = member.getUserCredentials().getUsername();    	    
    		Authority authority = new Authority();
    	    authority.setUsername(username);
    	    authority.setAuthority("ROLE_USER");
    	    member.getUserCredentials().addAuthority(authority);
    		
    	    return saveMember(member);
    }
    
    public void validateMember(Member member) throws EmailTakenException, UsernameTakenException {
        String username = member.getUserCredentials().getUsername();
        String email = member.getEmail();

        // Check duplicate for the case add new member
        if (member.getId() == null) {
            if (credentialsService.findByUsername(username) != null) {
                throw new UsernameTakenException("Username is already taken: " + username);
            }

            if (!findByEmail(email).isEmpty()) {
                throw new EmailTakenException("Email is already exists: " + email);
            }        	
        }
    }
}
