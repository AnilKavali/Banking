package com.manager.curd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.curd.model.Accounts;
import com.manager.curd.repo.ManagerRepository;

@Service
public class ManagerServiceImpl  implements ManagerService{

	@Autowired
	ManagerRepository repo;
	
	@Override
	public List<Accounts> findAllAccounts() {
		// TODO Auto-generated method stub
		System.out.println("findAllNotes>>>>>>>"+repo.findAll().size());
		return repo.findAll();
	}
	
	@Override
	public Accounts insertAccounts(Accounts student) {
		// TODO Auto-generated method stub
		
		return repo.save(student);
	}

	@Override
	public String updateCustomer(Accounts customer) {
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
	public Optional<Accounts> findById(int custId) {
		// TODO Auto-generated method stub
		return repo.findById(custId);
		
	}

	@Override
	public Optional<Accounts> findByName(String name) {
		// TODO Auto-generated method stub
		return repo.findByAccType(name);
	}

	


}
