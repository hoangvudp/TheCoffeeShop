package mum.waa.coffee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.waa.coffee.domain.ProductCategory;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long>{

}
