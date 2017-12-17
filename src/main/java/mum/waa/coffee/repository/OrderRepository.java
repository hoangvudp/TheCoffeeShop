package mum.waa.coffee.repository;

import mum.waa.coffee.domain.Order;
import mum.waa.coffee.domain.Person;
import mum.waa.coffee.domain.Product;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findDistinctOrderByOrderLines_Product(Product product);

    List<Order> findOrderByPerson(Person person);

    List<Order> findOrderByOrderDateBetween(Date minDate, Date maxDate);


}
