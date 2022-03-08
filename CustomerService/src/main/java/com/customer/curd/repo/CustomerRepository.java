package com.customer.curd.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.customer.curd.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	 @Query("select c from Customer c where c.cname=?1")
	 public Optional<Customer> findByCustName(String name);

}
