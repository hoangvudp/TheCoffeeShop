package mum.waa.coffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.waa.coffee.domain.UserCredentials;


@Repository
public interface UserCredentialsRepository extends CrudRepository<UserCredentials,String> {
  
	public UserCredentials findByUsername(String username);
}
