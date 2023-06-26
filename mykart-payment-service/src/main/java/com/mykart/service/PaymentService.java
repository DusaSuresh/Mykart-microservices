package com.mykart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mykart.entity.Payment;

@Service
public interface PaymentService {

	ResponseEntity<Payment> savePayment(Payment payment);

	ResponseEntity<Payment> getPayment(Long paymentId);
	
	ResponseEntity<String> updatePayment(Long paymentId, Payment payment);

	ResponseEntity<String> deletePayment(Long paymentId);

}
