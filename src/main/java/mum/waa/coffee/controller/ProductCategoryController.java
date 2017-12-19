package mum.waa.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import mum.waa.coffee.domain.ProductCategory;
import mum.waa.coffee.service.ProductCategoryService;

@Controller
@RequestMapping(value="categories")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody ProductCategory addProductCategory(@RequestBody ProductCategory productCategory, Model model) {
		productCategoryService.save(productCategory);
		return productCategory;
	}
}
