package mum.waa.coffee.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.waa.coffee.domain.ProductCategory;
import mum.waa.coffee.repository.ProductCategoryRepository;
import mum.waa.coffee.service.ProductCategoryService;

@Service
@Transactional
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@Override
	public ProductCategory save(ProductCategory product) {
		return productCategoryRepository.save(product);
	}

	@Override
	public void delete(Long productId) {
		productCategoryRepository.delete(productId);;
	}

	@Override
	public ProductCategory getProduct(Long productId) {
		return productCategoryRepository.findOne(productId);
	}

	@Override
	public List<ProductCategory> getAllCategories() {
		return (List<ProductCategory>) productCategoryRepository.findAll();
	}

}
