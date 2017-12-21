package mum.waa.coffee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mum.waa.coffee.service.OrderService;
import mum.waa.coffee.service.ProductService;
import mum.waa.coffee.domain.*;

@Controller
@SessionAttributes({"person", "productList"})
public class OrderController {
	
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
		
		return "orderSuccess";
	}

}
