package com.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.BankAccountDAO;
import com.sample.dao.ProductDAO;
import com.sample.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private BankAccountDAO bankAccountDAO;

	@Override	
	@Transactional
	public void purchaseProduct(int accountNumber, int productCode, int count, double price)  {
		productDAO.descreaseStockCount(productCode,count );
		bankAccountDAO.withdraw(accountNumber,count*price );
		
	}
}
