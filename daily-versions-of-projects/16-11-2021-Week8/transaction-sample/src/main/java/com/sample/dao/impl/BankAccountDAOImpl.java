package com.sample.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sample.dao.BankAccountDAO;

@Repository
public class BankAccountDAOImpl implements BankAccountDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public void withdraw(int accountNumber, double amount)   {	
		jdbcTemplate.update("update bank_accountt set balance=balance-? where account_number=?", new Object[] { amount,accountNumber });
		
	}
	
}
