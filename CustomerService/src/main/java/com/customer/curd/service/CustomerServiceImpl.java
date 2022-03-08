package com.customer.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.curd.model.Customer;
import com.customer.curd.repo.CustomerRepository;

@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	CustomerRepository repo;
	
    @Autowired
	private CustomerProxy proxy;
	
	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		System.out.println("findAllNotes>>>>>>>"+repo.findAll().size());
		return repo.findAll();
	}
	
	/*
	  @Override 
	  public Customer registerCustomer(Customer customer) {
	  repo.save(customer); 
	  return "Inserted successfully"; 
	 }
	 */
	
	@Override
    public Customer registerCustomer(Customer customer) {

        return repo.save(customer);
    }

	@Override
	public String updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		repo.save(customer);
		return "Notes updated successfully";
	}

	@Override
	public String deleteCustomer(int custId) {
		// TODO Auto-generated method stub
		repo.deleteById(custId);
		return "Notes deleted";
	}
	
	
	@Override
	public Optional<Customer> findById(int custId) {
		// TODO Auto-generated method stub
		return repo.findById(custId);
		
	}

	@Override
	public Optional<Customer> findByCustName(String name) {
		// TODO Auto-generated method stub
		return repo.findByCustName(name);
	}

	


}
