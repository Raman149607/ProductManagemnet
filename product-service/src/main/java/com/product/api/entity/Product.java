package com.product.api.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

	@Id
	private String productId;
	private String productName;
	private String productBigImage;
	private String productThumbnail;
	private String productDescription;
	private String productShortDecription;
	private int productRatings;
	private double price;
	private boolean isActive;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String productBigImage, String productThumbnail, String productDescription,
			String productShortDecription, int productRatings, double price, boolean isActive) {
		super();
		this.productName = productName;
		this.productBigImage = productBigImage;
		this.productThumbnail = productThumbnail;
		this.productDescription = productDescription;
		this.productShortDecription = productShortDecription;
		this.productRatings = productRatings;
		this.price = price;
		this.isActive = isActive;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductBigImage() {
		return productBigImage;
	}

	public void setProductBigImage(String productBigImage) {
		this.productBigImage = productBigImage;
	}

	public String getProductThumbnail() {
		return productThumbnail;
	}

	public void setProductThumbnail(String productThumbnail) {
		this.productThumbnail = productThumbnail;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductShortDecription() {
		return productShortDecription;
	}

	public void setProductShortDecription(String productShortDecription) {
		this.productShortDecription = productShortDecription;
	}

	public int getProductRatings() {
		return productRatings;
	}

	public void setProductRatings(int productRatings) {
		this.productRatings = productRatings;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getisActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	

}
