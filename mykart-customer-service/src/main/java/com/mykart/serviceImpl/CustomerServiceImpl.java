package com.mykart.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import com.mykart.entity.Customer;
import com.mykart.repository.CustomerRepository;
import com.mykart.service.CustomerService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component("customerImpl")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public ResponseEntity<Customer> saveCustomer(Customer customer) {
		log.info("Inside savecustomer method of customer service implementation");
		return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<Customer> getCustomer(Long customerId) {
		log.info("Inside getcustomer method of customer service implementation");
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			return new ResponseEntity<>(customerOptional.get(), HttpStatus.ACCEPTED);
		}else {
			return null;
		}
	} 
	
	public ResponseEntity<String> updateCustomer(Long customerId, @Valid Customer updatedCustomer) {
		// Retrieve the customerId from the repository
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        // Check if the customer exists
        if (optionalCustomer.isPresent()) {
            Customer existingCustomer = optionalCustomer.get();

            // Update the customer
            existingCustomer.setEmail(updatedCustomer.getEmail());
            existingCustomer.setAddress(updatedCustomer.getAddress());

            // Save the updated customer using the repository
            customerRepository.save(existingCustomer);

            // Return success response
            return ResponseEntity.ok("Custmer updated successfully");
        } else {
            // Return a not found response
            return ResponseEntity.notFound().build();
        }

	}
	
	@Override
	public ResponseEntity<String> deleteCustomer(Long customerId) {
		log.info("Inside deleteCustomer method of customer service implementation");
		customerRepository.deleteById(customerId);
		return new ResponseEntity<>("Successfully deleted", HttpStatus.ACCEPTED);
	}


	
	

}
