package mum.waa.coffee.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.waa.coffee.domain.Order;
import mum.waa.coffee.domain.Member;
import mum.waa.coffee.domain.Product;
import mum.waa.coffee.repository.OrderRepository;
import mum.waa.coffee.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

 	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public Order save(Order order) {
        return orderRepository.save(order);
    }

 	@PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(Order order) {
        orderRepository.delete(order);
    }

    public List<Order> findByProduct(Product product) {
        return orderRepository.findDistinctOrderByOrderLines_Product(product);
    }

    public List<Order> findByPerson(Member person) {
        return orderRepository.findOrderByPerson(person);
    }

    public List<Order> findByDate(Date minDate, Date maxDate) {
        return orderRepository.findOrderByOrderDateBetween(minDate, maxDate);
    }

    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    public List<Order> findAll() {
        return (List<Order>) orderRepository.findAll();
    }

}
