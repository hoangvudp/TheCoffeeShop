package mum.waa.coffee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.coffee.domain.UserCredentials;
import mum.waa.coffee.repository.UserCredentialsRepository;
import mum.waa.coffee.service.UserCredentialsService;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void save(UserCredentials credentials) {
		String inputPassword = credentials.getInputPassword();
		
		if (inputPassword != null && inputPassword.length() > 0) {
			String encodedPassword = passwordEncoder.encode(inputPassword);
			credentials.setPassword(encodedPassword);
		}

		userCredentialsRepository.save(credentials);
	}

	public void update(UserCredentials userCredentials) {
		userCredentialsRepository.save(userCredentials);
	}

	public List<UserCredentials> findAll() {
		return (List<UserCredentials>) userCredentialsRepository.findAll();
	}

	public UserCredentials findOne(String id) {
		return userCredentialsRepository.findOne(id);
	}

	public UserCredentials findByUsername(String userName) {
		return userCredentialsRepository.findByUsername(userName);
	}
}
