package mum.waa.coffee.service.impl;

import mum.waa.coffee.domain.Product;
import mum.waa.coffee.domain.ProductCategory;
import mum.waa.coffee.repository.ProductRepository;
import mum.waa.coffee.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long productId) {
        productRepository.delete(productId);
    }

    public Product getProduct(Long productId) {
        return productRepository.findOne(productId);
    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> findByTextSearch(String criteria) {
        if (!criteria.contains("%")) {
            criteria = "%" + criteria + "%";
        }
        return productRepository.findByProductNameLikeOrDescriptionLikeAllIgnoreCase(criteria, criteria);
    }

    public List<Product> findByPrice(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Product> findByProductCategory(ProductCategory productCategory) {
        return productRepository.findByProductCategory(productCategory);
    }

}
