package com.shop.test;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shop.model.Address;
import com.shop.model.Customer;
import com.shop.model.Order;
import com.shop.model.Product;
import com.shop.model.Shop;
import com.shop.service.ShopService;
@SpringBootTest
class TestShopService {
	@Autowired
	ShopService service;

	@Test
	void createShop() {
		Shop shop=new Shop();
		shop.setName("TEKNOLOJI MERKEZI");
		shop.setAddress("MAVI EVLER MAHALLESI. SELCUKBEY CAD. NO: 1");
		Product product1=new Product();
		product1.setName("IPhone 13 Pro Max");
		product1.setPrice(28500);
		
		Product product2=new Product();
		product2.setName("IPad 9");
		product2.setPrice(3900);
		
		Product product3=new Product();
		product3.setName("Lenovo ThinkPad E14");
		product3.setPrice(15200);
		
		Customer customer=new Customer();
		customer.setFirstName("ESMA");
		customer.setLastName("MERAL");
		
		
		
		Address address=new Address();
		address.setCity("ISTANBUL");
		address.setText("MAVI EVLER MAHALLESI. SELCUKBEY CAD. NO: 112");
		customer.setAddress(address);
		shop.getProducts().add(product1);
		shop.getProducts().add(product2);
		shop.getProducts().add(product3);
		product1.setShop(shop);
		product2.setShop(shop);
		product3.setShop(shop);
		
		shop.getCustomers().add(customer);
		customer.setShop(shop);
		Order order=new Order();
		order.setAmount(100);
		order.setCustomer(customer);
		order.setDate(new Date());
		order.getProducts().add(product1);
		order.getProducts().add(product2);
		
		product1.getOrders().add(order);
		product2.getOrders().add(order);
		service.save(shop);
	}

}
