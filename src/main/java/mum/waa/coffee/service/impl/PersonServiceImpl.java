package mum.waa.coffee.service.impl;

import mum.waa.coffee.domain.Authority;
import mum.waa.coffee.domain.Person;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;
import mum.waa.coffee.repository.PersonRepository;
import mum.waa.coffee.service.PersonService;
import mum.waa.coffee.service.UserCredentialsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
	@Autowired
    private PersonRepository personRepository;
    
 	@Autowired
 	UserCredentialsService credentialsService;

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Person savePerson(Person person) {  
  		credentialsService.save(person.getUserCredentials());
  		return personRepository.save(person);
    }

    public List<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public Person findById(Long id) {
        return personRepository.findOne(id);
    }

    public void removePerson(Person person) {
        personRepository.delete(person);
    }

    public void removePerson(Long id) {
        personRepository.delete(id);
    }

    public Person registerNewPerson(Person person) throws EmailTakenException, UsernameTakenException {
        String username = person.getUserCredentials().getUsername();
        String email = person.getEmail();

        if (credentialsService.findByUsername(username) != null) {
            throw new UsernameTakenException("Username is already taken: " + username);
        }

        if (!findByEmail(email).isEmpty()) {
            throw new EmailTakenException("Email is already exists: " + email);
        }

        Authority authority = new Authority();
        authority.setUsername(username);
        authority.setAuthority("ROLE_USER");
        
        person.getUserCredentials().addAuthority(authority);

        return savePerson(person);
    }
}
