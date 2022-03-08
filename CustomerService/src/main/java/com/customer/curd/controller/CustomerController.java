package com.customer.curd.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.curd.model.Customer;
import com.customer.curd.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		ResponseEntity<?> resp = null;
		try {
			Customer cust1 = service.registerCustomer(customer);

			resp = new ResponseEntity<Customer>(cust1, HttpStatus.CREATED);

		} catch (Exception e) {
			resp = new ResponseEntity<String>("Customer details not saved, Please check", HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return resp;

	}
	
	@GetMapping("/getCustomer")
	public ResponseEntity<?> getCustomerDtls() {

		ResponseEntity<?> resp = null;
		try {
			List<Customer> listOfCust = service.findAllCustomers();

			resp = new ResponseEntity<List<Customer>>(listOfCust, HttpStatus.FOUND);

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

	
	@PutMapping("/modify")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity(service.updateCustomer(customer), HttpStatus.CREATED);
		
	}
	
	/*
	  @GetMapping("/all") 
	  public ResponseEntity<Customer> getCustomersAll(){
	   return new ResponseEntity(service.findAllCustomers(), HttpStatus.OK); 
	  }
	 */

	/*
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer customer) {
		return new ResponseEntity(service.registerCustomer(customer), HttpStatus.CREATED);
	}
	*/
	
	/*
	 * @DeleteMapping("/delete/{custId}") public ResponseEntity<String>
	 * deleteCustomer(@PathVariable("custId") int custId){ return new
	 * ResponseEntity(service.deleteCustomer(custId), HttpStatus.ACCEPTED); }
	 */

	
	@PostMapping("/custId/{custId}")
	public ResponseEntity<Optional<Customer>> getCustomerByCustId(@PathVariable("custId") int custId){
		return new ResponseEntity(service.findById(custId), HttpStatus.OK);
	}
	
	
	@PostMapping("/search/{name}")
	public ResponseEntity<Optional<Customer>> findByCustName(@PathVariable("name") String name){
		
		return new ResponseEntity(service.findByCustName(name), HttpStatus.OK);
	}
	
	
}
