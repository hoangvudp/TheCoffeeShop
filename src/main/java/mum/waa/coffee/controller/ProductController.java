package mum.waa.coffee.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.ProductCategory;
import mum.waa.coffee.exception.ProductNotFoundException;
import mum.waa.coffee.service.ProductCategoryService;
import mum.waa.coffee.service.ProductService;

@Controller
@RequestMapping(value="/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductCategoryService productCategoryService;
	@Autowired
	ServletContext servletContext;
	
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
		if(product == null) {
			throw new ProductNotFoundException(id, null);
		}
		
		model.addAttribute("product", product);
		return "product";
	}
	
	@RequestMapping(value="/add")
	public String addProduct(Model model, Product product, ProductCategory productCategory) {
//		model.addAttribute("product", new Product());
		return "editProduct";
	}
	
	@RequestMapping(value= {"/add", "/edit/{id}"}, method=RequestMethod.POST)
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model, ProductCategory productCategory) {
		if(result.hasErrors()) {
			return "editProduct";
		}
		Product savedProduct = productService.save(product);
		boolean isAdd = product.getId() == null;
		
		String[] suppressedFields = result.getSuppressedFields();

		if (suppressedFields.length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: "
					+ StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = servletContext.getRealPath("/");

		// isEmpty means file exists BUT NO Content
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(
						new File(rootDirectory + "\\images\\" + savedProduct.getId() + ".jpg"));
			} catch (Exception e) {
				throw new RuntimeException("Product Image saving failed", e);
			}
		}
		
		
		if (isAdd) {
		}
		return "redirect:/products";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editProduct(@PathVariable("id") Long id, Model model, ProductCategory productCategory) {
		Product product = productService.getProduct(id);
		if(product == null) {
			throw new ProductNotFoundException(id, null);
		}
		model.addAttribute("product", product);
		return "editProduct";
	}
	
	@RequestMapping(value="/delete/{id}")
	public String deleteProduct(@PathVariable("id") Long id, Model model) {
		productService.delete(id);
		return "redirect:/products";
	}
}
