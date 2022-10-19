package com.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.model.Shop;
import com.shop.repo.ShopRepository;

@Service
public class ShopService {
	@Autowired
	private ShopRepository shopRepository;
	
	public Shop save(Shop shop) {
		
		return shopRepository.save(shop);
		
	}

}
