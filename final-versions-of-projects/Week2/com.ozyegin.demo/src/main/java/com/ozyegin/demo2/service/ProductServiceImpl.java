package com.ozyegin.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ozyegin.demo2.repo.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository repository;
	
	public ProductRepository getRepository() {
		return repository;
	}

	public void setRepository(ProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Double getProductPriceByCode(int code) {
		Double price=repository.getProductPriceByCode(code);
		price*=1.10;
		return price;
		
	}

}
