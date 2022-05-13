package com.product.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.api.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String>{

}
