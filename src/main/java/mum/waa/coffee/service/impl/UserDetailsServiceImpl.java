package mum.waa.coffee.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.coffee.domain.Authority;
import mum.waa.coffee.domain.UserCredentials;
import mum.waa.coffee.repository.UserCredentialsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials credentials = userCredentialsRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Authority auth : credentials.getAuthority()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
        }

        return new org.springframework.security.core.userdetails.User(credentials.getUsername(), credentials.getPassword(), grantedAuthorities);
    }
}
