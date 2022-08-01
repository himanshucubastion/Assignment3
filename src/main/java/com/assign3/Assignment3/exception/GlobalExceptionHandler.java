package com.assign3.Assignment3.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
		
		return new ResponseEntity<String>("Input field is Empty,Please look into it",
				HttpStatus.BAD_REQUEST);
	
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException element){
		
		return new ResponseEntity<String>("No value is present, Please change your request",
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateEntry.class)
	public ResponseEntity<String> handleDupicateEntry(DuplicateEntry duplicate){
		
		return new ResponseEntity<String>("Duplicate entry, Give an unique input",
				HttpStatus.UNAUTHORIZED);
	}
}
