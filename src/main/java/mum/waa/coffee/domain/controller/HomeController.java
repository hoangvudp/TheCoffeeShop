package mum.waa.coffee.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mum.waa.coffee.serviceimpl.ProductServiceImpl;

@Controller
public class HomeController {
	@Autowired
	private ProductServiceImpl productService;

	@RequestMapping(value= {"/", "/index"})
	public String displayHomePage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "index";
	}
}
