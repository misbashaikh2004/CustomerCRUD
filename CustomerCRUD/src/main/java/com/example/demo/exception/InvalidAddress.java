package com.example.demo.exception;

public class InvalidAddress extends RuntimeException{
	
	public InvalidAddress(String message) {
		super(message);
	}

}
