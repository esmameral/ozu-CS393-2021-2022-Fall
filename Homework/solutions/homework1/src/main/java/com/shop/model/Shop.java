package com.shop.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_SHOP")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(length = 300)
	private String address;
	
	@OneToMany(mappedBy = "shop",cascade = CascadeType.ALL)
	private List<Product> products=new ArrayList<>();
	
	@OneToMany(mappedBy = "shop",cascade = CascadeType.ALL)
	private List<Customer> customers=new ArrayList<>();

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	
	
	

}
