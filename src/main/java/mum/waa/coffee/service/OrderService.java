package mum.waa.coffee.service;

import java.util.Date;
import java.util.List;

import mum.waa.coffee.domain.Order;
import mum.waa.coffee.domain.Member;
import mum.waa.coffee.domain.Product;

public interface OrderService {

    public Order save(Order order);

    public void delete(Order order);

    public List<Order> findByProduct(Product product);

    public List<Order> findByMember(Member member);

    public List<Order> findByDate(Date minDate, Date maxDate);

    public Order findById(Long id);

    public List<Order> findAll();

}
