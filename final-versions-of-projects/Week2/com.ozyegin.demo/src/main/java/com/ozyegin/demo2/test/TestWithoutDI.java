package com.ozyegin.demo2.test;

import com.ozyegin.demo2.repo.ProductRepositoryImpl;
import com.ozyegin.demo2.service.ProductServiceImpl;

public class TestWithoutDI {

	public static void main(String[] args) {
		ProductRepositoryImpl repo=new ProductRepositoryImpl();
		repo.setPassword("1234");
		repo.setUsername("esma");
		repo.setUrl("jdbc:derby://localhost:1527/demodb;create=true");
	
		ProductServiceImpl srv= new ProductServiceImpl();
		srv.setRepository(repo);
		
		System.out.println(srv.getProductPriceByCode(0));
	}

}
