package com.sample.model;

public class Product {
	
	private int productCode;
	
	private String productName;
	
	private Double price;
	
	private Integer stockCount;

	
	public Product() {
		super();
	}

	
	public Product(int productCode, String productName, Double price, Integer stockCount) {
		super();
		this.productCode=productCode;
		this.productName = productName;
		this.price = price;
		this.stockCount = stockCount;
	}


	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStockCount() {
		return stockCount;
	}

	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}

}
