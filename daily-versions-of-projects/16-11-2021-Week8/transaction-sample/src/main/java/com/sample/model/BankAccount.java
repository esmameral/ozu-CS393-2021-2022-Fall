package com.sample.model;

public class BankAccount {

	private String owner;
	private double balance;
	
	private int accountNumber;

	public BankAccount() {
		super();
	}
	
	public BankAccount(int accountNumber,String owner, double balance) {
		super();
		this.accountNumber=accountNumber;
		this.owner = owner;
		this.balance = balance;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	
}
