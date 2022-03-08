package com.customer.curd.service;

import java.util.List;
import java.util.Optional;

import com.customer.curd.model.Customer;


public interface CustomerService {

	public List<Customer> findAllCustomers();
	//public String registerCustomer(Customer customer);
	
	public Customer registerCustomer(Customer customer);
	
	public String updateCustomer(Customer customer);
	public String deleteCustomer(int cId);
	
	public Optional<Customer> findById(int cId);
	public Optional<Customer> findByCustName(String name);
	
	
}
