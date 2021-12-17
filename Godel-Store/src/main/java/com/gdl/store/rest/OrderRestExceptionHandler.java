package com.gdl.store.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gdl.store.rest.exception.OrderNotFoundException;

@ControllerAdvice
public class OrderRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(OrderNotFoundException exc) {
		
		
		OrderErrorResponse error = new OrderErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
		
	@ExceptionHandler
	public ResponseEntity<OrderErrorResponse> handleException(Exception exc) {
		
		OrderErrorResponse error = new OrderErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
