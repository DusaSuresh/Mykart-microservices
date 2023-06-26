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

import com.mykart.entity.Payment;
import com.mykart.service.PaymentService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/payments")
@Slf4j
public class PaymentController {
	
	@Autowired
	@Qualifier("paymentImpl")
	PaymentService paymentService;
	
	@PostMapping
	public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
		log.info("Inside savepayment method of payment Controller");
		return paymentService.savePayment(payment);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Payment> getPayment(@PathVariable("id") Long paymentId) {
		log.info("Inside getpayment method of payment controller");
		return paymentService.getPayment(paymentId);
	}
	
	@PutMapping("/{paymentId}")
	public ResponseEntity<String> updatedPayment(@PathVariable Long productId, @Valid @RequestBody Payment updatedPayment) {

		log.info("****** Request in paymentId controller ****** Method is updatedPayment");
		return paymentService.updatePayment(productId, updatedPayment);
	}

	@DeleteMapping("/{paymentId}")
	public ResponseEntity<String> deletePayment(@PathVariable Long paymentId) {

		log.info("****** Request in paymentId controller ****** Method is  deletePayment");
		return paymentService.deletePayment(paymentId);

	}


}
