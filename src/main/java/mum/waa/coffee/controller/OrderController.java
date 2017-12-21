package mum.waa.coffee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


import mum.waa.coffee.service.OrderService;
import mum.waa.coffee.service.MemberService;
import mum.waa.coffee.service.ProductService;
import mum.waa.coffee.domain.*;
import mum.waa.coffee.repository.UserCredentialsRepository;

@Controller
@SessionAttributes({"person", "productList"})
public class OrderController {
	@Autowired
	private UserCredentialsRepository userRepository;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.GET)
	public String placeOrder(Order order, Model model){
		order.addOrderLine(new OrderLine());
        order.setOrderDate(new Date());

		model.addAttribute("products", productService.getAllProducts());
		return "order";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String placeOrder(@Valid @ModelAttribute("order") Order order, BindingResult result, Model model){
		
		if(result.hasErrors()){
			return "placeOrder";
		}
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCredentials userCredentials = userRepository.findByUsername(user.getUsername());
		order.setMember(userCredentials.getMember());
		for (int i = 0; i < order.getOrderLines().size(); i++) {
			order.getOrderLines().get(i).setOrder(order);
		}
		Order saveOrder = orderService.save(order);
		System.out.println(saveOrder.getId());
		
		return "orderSuccess";
	}
	
	@RequestMapping(value = "/add", params = "addOrderLine", method = RequestMethod.POST)
    public String addOrderLine(Order order, BindingResult result) {
        OrderLine orderLine = new OrderLine();
        order.addOrderLine(orderLine);

        return "order/add";
    }

    @RequestMapping(value = "/add", params = "removeOrderLine", method = RequestMethod.POST)
    public String removeOrderLine(Order order, BindingResult result, HttpServletRequest request) {
        int orderLineId = Integer.valueOf(request.getParameter("removeOrderLine"));
        order.getOrderLines().remove(orderLineId);

        return "order/add";
    }
	
	@RequestMapping(value="/allOrders", method=RequestMethod.GET)
	public String showAllOrders(Model model){

		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("orders", orderService.findAll());
		return "allOrders";
	}

}
