package com.product.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.api.entity.Product;
import com.product.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {

		return productRepository.insert(product);

	}

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> productById(String id) {
		return productRepository.findById(id);
	}

	public List<Product> findByName(String productName) {
		return productRepository.findByProductName(productName);
	}

	public String deleteById(String id) {
		productRepository.deleteById(id);
		return "Product Deleted" +""+id;
	}

}
