package com.manager.curd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.curd.model.Accounts;
import com.manager.curd.service.ManagerService;

@RestController
@RequestMapping("/managers")
public class ManagerController {
	
	@Autowired
	ManagerService service;
	
	
	@PostMapping("/addAccounts")
	public ResponseEntity<?> insertAccounts(@RequestBody Accounts accounts) {
		ResponseEntity<?> resp = null;
		try {
			Accounts cust1 = service.insertAccounts(accounts);

			resp = new ResponseEntity<Accounts>(cust1, HttpStatus.CREATED);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Account details not saved, Please check", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;

	}
	
	@GetMapping("/getCustomer")
	public ResponseEntity<?> getAccntDtls() {

		ResponseEntity<?> resp = null;
		try {
			List<Accounts> listOfCust = service.findAllAccounts();

			resp = new ResponseEntity<List<Accounts>>(listOfCust, HttpStatus.FOUND);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Customer is not found, Please check", HttpStatus.INTERNAL_SERVER_ERROR);

		}

		return resp;
	}
	
	@DeleteMapping("/delete/{custId}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("custId") int custId) {
		ResponseEntity<?> resp = null;

		try {
			service.deleteCustomer(custId);
			resp = new ResponseEntity<String>("Customer of id= " + custId + "deleted successfully", HttpStatus.OK);
			
		} catch (Exception e) {

			resp = new ResponseEntity<String>("Customer of id= " + custId + "not deleted,Please Check",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return resp;
	}
	
	
	
	@PostMapping("/search/{name}")
	public ResponseEntity<Optional<Accounts>> findByName(@PathVariable("name") String name){
		
		return new ResponseEntity(service.findByName(name), HttpStatus.OK);
	}
	
	
}
