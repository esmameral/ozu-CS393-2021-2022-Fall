package com.ozyegin.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ozyegin.demo2.service.ProductService;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	ProductService service;

	@Test
	void contextLoads() {
		
		System.out.println(service.getProductPriceByCode(100));
	}

}
