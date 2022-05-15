package com.product.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.api.Repository.ProductRepository;
import com.product.api.entity.Product;
import com.product.api.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/Products")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
			List<Product> products = new ArrayList<Product>();
			productService.getProducts().forEach(products::add);

			if (products.isEmpty())
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(products, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") String id) {
		Optional<Product> productData = productService.ProductById(id);
		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/Products/name/{productName}")
	public ResponseEntity<List<Product>> findByProductName(@PathVariable String productName) {
		try {
			List<Product> products = new ArrayList<Product>();
			productService.findByName(productName).forEach(products::add);
			if (products.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/Products")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		try {
			productService.saveProduct(product);
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/Products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
		 Optional<Product> productData = productRepository.findById(id);
		  if (productData.isPresent()) {
		    Product _Product = productData.get();
		    _Product.setProductName(product.getProductName());
		    _Product.setProductBigImage(product.getProductBigImage());
		    _Product.setProductThumbnail(product.getProductThumbnail());
		    _Product.setProductDescription(product.getProductDescription());
		    _Product.setProductShortDecription(product.getProductShortDecription());
		    _Product.setProductRatings(product.getProductRatings());
		    _Product.setPrice(product.getPrice());
		    _Product.setActive(product.getisActive());
		   
		    return new ResponseEntity<>(productRepository.save(_Product), HttpStatus.OK);
		  } else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		  }
	}

	@DeleteMapping("/Products/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") String id) {
		try {
		  productService.deleteById(id);
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  } catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}

}