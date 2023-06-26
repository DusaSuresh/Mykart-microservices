package com.mykart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mykart.entity.Customer;

@Service
public interface CustomerService {

	ResponseEntity<Customer> saveCustomer(Customer customer);

	ResponseEntity<Customer> getCustomer(Long customerId);
	
	ResponseEntity<String> updateCustomer(Long customerId, Customer customer);

	ResponseEntity<String> deleteCustomer(Long customerId);


}
