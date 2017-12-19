package mum.waa.coffee.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.ProductCategory;
import mum.waa.coffee.service.ProductCategoryService;
import mum.waa.coffee.service.ProductService;

@Controller
@RequestMapping(value="/products")
@SessionAttributes("productCategories")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService productCategoryService;
	
	@ModelAttribute("categories")
    public List<ProductCategory> getProductCategoryList(Model model) {
		return productCategoryService.getAllCategories();
    }
	
	@RequestMapping()
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping(value="{id}")
	public String getProductById(@PathVariable("id")Long id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "product";
	}
	
	@RequestMapping(value="/add")
	public String addProduct(Model model) {
		model.addAttribute("product", new Product());
		return "editProduct";
	}
	
	@RequestMapping(value= {"/add", "/edit/{id}"}, method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, RedirectAttributes ra) {
		if(result.hasErrors()) {
			return "editProduct";
		}
		boolean isAdd = product.getId() == null;
		productService.save(product);
		if (isAdd) {
		}
		return "redirect:/products";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProduct(id);
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		productService.delete(id);
		return "redirect:/products";
	}
}
