package com.sample.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sample.AppConfig;
import com.sample.service.PurchaseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestPurchaseService {

	@Autowired
	PurchaseService purchaseService;
	

	@Test
	public void testPurchase() {	
		purchaseService.purchaseProduct(345,40,2,200);
	}

}
