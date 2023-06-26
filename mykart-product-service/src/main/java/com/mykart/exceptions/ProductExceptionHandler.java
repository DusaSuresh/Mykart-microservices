package com.mykart.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.mykart.entity.ProductResponseVO;

@ControllerAdvice
public class ProductExceptionHandler{
	
	@Autowired
	ProductResponseVO productResponseVO;
	
	// Exception handling
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		
    	productResponseVO.setTimeStamp(System.currentTimeMillis());
    	productResponseVO.setMessage("Order input validations failed");
		
		List<String> errors = ex.getBindingResult().getFieldErrors().stream()
							.map(x -> x.getDefaultMessage())
							.collect(Collectors.toList());
		productResponseVO.setErrors(errors);
		
		
		return new ResponseEntity<>(productResponseVO, status);
	}
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception ex) {
    	
    	productResponseVO.setTimeStamp(System.currentTimeMillis());
    	productResponseVO.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(productResponseVO);
    }
	
	
	

}
