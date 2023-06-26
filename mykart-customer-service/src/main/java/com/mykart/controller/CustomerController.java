package com.mykart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mykart.entity.Customer;
import com.mykart.service.CustomerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {
	
	@Autowired
	@Qualifier("customerImpl")
	CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Customer> savecustomer(@RequestBody Customer customer) {
		log.info("Inside savecustomer method of customer Controller");
		return customerService.saveCustomer(customer);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> getcustomer(@PathVariable("id") Long customerId) {
		log.info("Inside getcustomer method of customer controller");
		return customerService.getCustomer(customerId);
	}
	
	@PutMapping("/{customerId}")
	public ResponseEntity<String> updatedCustomer(@PathVariable Long customerId, @Valid @RequestBody Customer updatedCustomer) {

		log.info("****** Request in customer controller ****** Method is updatedCustomer");
		return customerService.updateCustomer(customerId, updatedCustomer);
	}

	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {

		log.info("****** Request in customerid controller ****** Method is  deleteCustomer");
		return customerService.deleteCustomer(customerId);

	}


}
