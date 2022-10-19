package com.ozyegin.demo2.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ozyegin.Application;
import com.ozyegin.demo2.service.ProductService;

public class TestDemo2 {
	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

		ProductService bean = context.getBean("productService", ProductService.class);
		System.out.println(bean.getProductPriceByCode(100));

	}
}
