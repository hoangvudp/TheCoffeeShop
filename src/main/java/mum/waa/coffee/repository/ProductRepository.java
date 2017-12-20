package mum.waa.coffee.repository;

import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.ProductCategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    public List<Product> findByProductNameLikeOrDescriptionLikeAllIgnoreCase(String productName, String description);

    public List<Product> findByProductCategory(ProductCategory productCategory);

    public List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
    
    public List<Product> findByProductCategoryId(Long productCategoryId);
}
