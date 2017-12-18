package mum.waa.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.waa.coffee.service.impl.ProductServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value= {"/", "/index"}, method=RequestMethod.GET)
	public String displayHomePage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
}
