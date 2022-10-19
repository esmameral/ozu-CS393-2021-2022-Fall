package com.bank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_ACCOUNT") 
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ACCOUNT_NUMBER",length = 10)
	private String accountNumber;
	private double balance;


	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REL_ACCOUNT_CUSTOMER", 
		joinColumns = @JoinColumn(name = "ACC_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "CUST_ID", referencedColumnName = "ID"))
	private List<Customer> customers = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "ACC_ID")
	private List<Transaction> transactions = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
