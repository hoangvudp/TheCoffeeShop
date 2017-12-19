package mum.waa.coffee.service;

import java.util.List;

import mum.waa.coffee.domain.ProductCategory;

public interface ProductCategoryService {
	public ProductCategory save(ProductCategory product);

    public void delete(Long productId);

    public ProductCategory getProduct(Long productId);

    public List<ProductCategory> getAllCategories();
}
