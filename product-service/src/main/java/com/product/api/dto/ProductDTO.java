package com.product.api.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.product.api.entity.Product;

@Document(collection = "Product")
public class ProductDTO extends Product{
	
	@Id
	private String productId;

}
