package com.product.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.Repository.ProductRepository;
import com.product.api.entity.Product;

@RestController
@RequestMapping("/Products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@PostMapping("/")
	public ResponseEntity<?> addProduct(@RequestBody Product product){
		Product save = this.productRepository.save(product);
		return ResponseEntity.ok(save);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getProducts(){
		return ResponseEntity.ok(this.productRepository.findAll());
			
	}

}
