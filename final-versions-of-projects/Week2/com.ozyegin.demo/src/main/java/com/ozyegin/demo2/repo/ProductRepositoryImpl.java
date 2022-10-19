package com.ozyegin.demo2.repo;

import org.springframework.stereotype.Repository;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {
	private String url;
	private String username;
	private String password;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public Double getProductPriceByCode(int code) {
		//TODO: read product info from database
		return 1250.75;
		
	}

}
