package com.shop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_ORDER")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date date;

	private double amount;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "CUST_ID")
	private Customer customer;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "REL_ORDER_PRODUCT", 
	joinColumns = @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID"), 
	inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
	private List<Product> products = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
