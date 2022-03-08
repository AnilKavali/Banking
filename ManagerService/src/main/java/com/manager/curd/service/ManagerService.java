package com.manager.curd.service;

import java.util.List;
import java.util.Optional;

import com.manager.curd.model.Accounts;


public interface ManagerService {

	public List<Accounts> findAllAccounts();
	public Accounts insertAccounts(Accounts accounts);
	public String updateCustomer(Accounts accounts);
	public String deleteCustomer(int cId);
	
	public Optional<Accounts> findById(int cId);
	public Optional<Accounts> findByName(String name);
	
	
}
