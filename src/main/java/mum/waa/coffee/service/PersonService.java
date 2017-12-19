package mum.waa.coffee.service;

import java.util.List;

import mum.waa.coffee.domain.Person;
import mum.waa.coffee.exception.EmailTakenException;
import mum.waa.coffee.exception.UsernameTakenException;

public interface PersonService {

    public List<Person> getAllPersons();

    public Person savePerson(Person person);

//    public Person findByUsername(String username);

    public List<Person> findByEmail(String email);

    public Person findById(Long id);

    public void removePerson(Person person);

    public void removePerson(Long id);

    public Person registerNewPerson(Person person) throws EmailTakenException, UsernameTakenException;
}
