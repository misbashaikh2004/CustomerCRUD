package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.InvalidId;
import com.example.demo.exception.InvalidMobileNumber;
import com.example.demo.exception.InvalidName;

@ControllerAdvice
public class GlobalExceptionHandler {
	

	@ExceptionHandler(InvalidMobileNumber.class)
	public ResponseEntity<?> invalidMobileNumber(InvalidMobileNumber e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}

	@ExceptionHandler(InvalidId.class)
	public ResponseEntity<?> InvalidId(InvalidId i) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(i.getMessage());
	}

	@ExceptionHandler(InvalidName.class)
	public ResponseEntity<?> InvalidName(InvalidName n) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(n.getMessage());

	}
}
