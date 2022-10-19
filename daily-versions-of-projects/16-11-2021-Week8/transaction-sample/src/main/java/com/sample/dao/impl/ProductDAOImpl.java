package com.sample.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.dao.ProductDAO;
@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void descreaseStockCount(int productCode, int count)  {
		jdbcTemplate.update("update product set stock_count=stock_count-? where product_code=?", new Object[] { count,productCode});		
		
	}
	
}
