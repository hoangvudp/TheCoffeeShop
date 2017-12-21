package mum.waa.coffee.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mum.waa.coffee.domain.Order;
import mum.waa.coffee.domain.OrderLine;
import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.UserCredentials;
import mum.waa.coffee.repository.UserCredentialsRepository;
import mum.waa.coffee.service.OrderService;
import mum.waa.coffee.service.ProductService;

@Controller
@RequestMapping(value="/orders")
@SessionAttributes("orderLineList")
public class PlaceOrderController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserCredentialsRepository userRepository;
	
	@ModelAttribute("products")
	public List<Product> getProductList(Model model) {
		return productService.getAllProducts();
	}
	
	@RequestMapping(value = "/add")
	public ModelAndView placeOrder(@ModelAttribute("order") Order order, OrderLine orderline, Model model) {
		order.setOrderDate(new Date());
		model.addAttribute("orderLineList", new ArrayList<>());
		ModelAndView mav = new ModelAndView();
		mav.setViewName("placeOrder");
		return mav;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order, OrderLine orderline, Model model) {
		List<OrderLine> orderLineList = (List<OrderLine>) model.asMap().get("orderLineList");
		order.setOrderLines(orderLineList);
		for (int i = 0; i < order.getOrderLines().size(); i++) {
			order.getOrderLines().get(i).setOrder(order);
		}
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserCredentials userCredentials = userRepository.findByUsername(user.getUsername());
		order.setMember(userCredentials.getMember());
		orderService.save(order);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/addProductToOrder", method = RequestMethod.GET)
	public @ResponseBody OrderLine addProductToOrder(@RequestParam("productId") String productId, @RequestParam("quantity") String quantity, Model model) {
		OrderLine orderLine = new OrderLine();
		orderLine.setProduct(productService.getProduct(Long.parseLong(productId)));
		orderLine.setQuantity(Integer.parseInt(quantity));
		List<OrderLine> orderLineList = (List<OrderLine>) model.asMap().get("orderLineList");
		orderLineList.add(orderLine);
		return orderLine;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String showAllOrders(Model model){

		model.addAttribute("products", productService.getAllProducts());
		model.addAttribute("orders", orderService.findAll());
		return "orders";
	}
}
