package com.mykart.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Data;

@Component
@Data
@Builder
public class CustomerResponseVO {
	
	private Long timeStamp;
	private String message;
	private List<String> errors;
	private Customer customer;

}
