package mum.waa.coffee.repository;


import mum.waa.coffee.domain.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
//    public Person findByUsername(String username);

    public List<Person> findByEmail(String email);

}
