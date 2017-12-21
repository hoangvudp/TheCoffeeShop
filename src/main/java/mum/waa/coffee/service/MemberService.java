package mum.waa.coffee.service;

import java.util.List;

import mum.waa.coffee.domain.Member;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;

public interface MemberService {

	public List<Member> getAllMembers();

	public Member saveMember(Member member) throws EmailTakenException, UsernameTakenException;

	public List<Member> findByEmail(String email);

	public Member findById(Long id);

	public void removeMember(Member member);

	public void removeMember(Long id);

	public Member registerNewMember(Member member) throws EmailTakenException, UsernameTakenException;
}
