package com.product.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.product.api.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	List<Product> findByProductName(String productName);

}
