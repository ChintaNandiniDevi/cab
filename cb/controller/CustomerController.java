package com.cap.cb.controller;

import java.util.List;

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

import com.cap.cb.entities.Customer;
import com.cap.cb.service.CustomerService;


@RestController
@RequestMapping("/api/c3")
public class CustomerController {

	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/insertCab")
	public ResponseEntity<Customer> insertCustomer(
			@RequestBody Customer customer)
	{
		Customer cust= customerService.insertCustomer(customer);
		if(cust==null)
		{
			return new ResponseEntity("sorry! customer is not inserted!", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	@PutMapping("/putCab")
	public ResponseEntity<Customer> updateCustomer(
			@RequestBody Customer customer){
		Customer cust= customerService.updateCustomer(customer);
		if(cust==null)
		{
			return new ResponseEntity("Sorry! customer not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	@DeleteMapping("/delCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(
			@PathVariable("customerId")Integer customerId){
		Customer cust= customerService.deleteCustomer(customerId);
		if(cust==null) {
			return new ResponseEntity("Sorry! customerId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewCustomers")
	public ResponseEntity<List<Customer>> viewCustomers(
			@RequestBody Customer customer){
		List<Customer> customers= customerService.viewCustomers();
		if(customers.isEmpty()) {
			return new ResponseEntity("Sorry! customers not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/viewCustomer")
	public ResponseEntity<Customer> viewCustomer(
			@PathVariable("custmorId")Integer customerId){
		Customer cust= customerService.viewCustomer(customerId);
		if(cust==null) {
			return new ResponseEntity("Sorry! customer not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	@GetMapping("/validateCustomer")
	public ResponseEntity<Customer> validateCustomer(
			@PathVariable("userName")String userName, @PathVariable("password")String password){
		Customer cust= customerService.validateCustomer(userName, password);
		if(cust==null) {
			return new ResponseEntity("Sorry! cant validate customer!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	
	
}
