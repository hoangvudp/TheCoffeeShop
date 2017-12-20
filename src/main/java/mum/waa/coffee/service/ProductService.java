package mum.waa.coffee.service;

import java.util.List;

import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.ProductCategory;

public interface ProductService {

    public Product save(Product product);

    public void delete(Long productId);

    public Product getProduct(Long productId);

    public List<Product> getAllProducts();

    public List<Product> findByTextSearch(String criteria);

    public List<Product> findByPrice(double minPrice, double maxPrice);

    public List<Product> findByProductCategory(ProductCategory productCategory);

    public List<Product> findByProductCategoryId(Long productCategoryId);
}
