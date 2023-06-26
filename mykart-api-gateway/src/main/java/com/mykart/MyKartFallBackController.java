package com.mykart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MyKartFallBackController {

	@GetMapping("/customerFallBack")
	public String customerServiceFallBackMethod() {
		return "Customer service is taking longer than exepected time... pls try it later";
	}
	
	@GetMapping("/inventoryFallBack")
	public String inventoryServiceFallBackMethod() {
		return "Inventory service is taking longer than exepected time... pls try it later";
	}
	
	@GetMapping("/orderFallBack")
	public String orderServiceFallBackMethod() {
		return "Order service is taking longer than exepected time... pls try it later";
	}
	
	@GetMapping("/paymentFallBack")
	public String paymentServiceFallBackMethod() {
		return "Payment service is taking longer than exepected time... pls try it later";
	}
	
	@GetMapping("/productFallBack")
	public String productServiceFallBackMethod() {
		return "Product service is taking longer than exepected time... pls try it later";
	}
}
