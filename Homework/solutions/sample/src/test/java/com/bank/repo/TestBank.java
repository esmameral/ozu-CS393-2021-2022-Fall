package com.bank.repo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bank.model.Account;
import com.bank.model.Customer;
import com.bank.model.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;
import com.bank.repository.TransactionRepository;

@SpringBootTest
class TestBank {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired 
	TransactionRepository transactionRepository;
	

	@Test
	
	void test() {
		
		
		Customer cust1=new Customer();
		cust1.setFirstName("Esma");;
		cust1.setLastName("Meral");
		
		Customer cust2=new Customer();
		cust2.setFirstName("Ece");;
		cust2.setLastName("Demir");
		
		Customer cust3=new Customer();
		cust3.setFirstName("Ahmet");;
		cust3.setLastName("Kaya");
		
		Account acc1=new Account();
		acc1.setAccountNumber("A123");
		acc1.setBalance(200);
		
		Account acc2=new Account();
		acc2.setAccountNumber("B345");
		acc2.setBalance(3000);
		
		
		acc1.getCustomers().add(cust1);
		acc1.getCustomers().add(cust2);
		
		acc2.getCustomers().add(cust1);
		acc2.getCustomers().add(cust3);
		
		cust1.getAccounts().add(acc1);
		cust1.getAccounts().add(acc2);
		
		cust2.getAccounts().add(acc1);
		cust3.getAccounts().add(acc2);		
		
		Transaction trx1=new Transaction();
		trx1.setAmount(200);
		trx1.setDate(new Date());
		
		Transaction trx2=new Transaction();
		trx2.setAmount(500);
		trx2.setDate(new Date());
		
		Transaction trx3=new Transaction();
		trx3.setAmount(50);
		trx3.setDate(new Date());
		
		acc1.getTransactions().add(trx1);
		acc2.getTransactions().add(trx2);
		acc2.getTransactions().add(trx3);
		
		accountRepository.save(acc1);
		accountRepository.save(acc2);
		
		
		
	}

}
