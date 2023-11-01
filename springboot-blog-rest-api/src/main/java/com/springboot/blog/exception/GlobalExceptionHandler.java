package com.springboot.blog.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.springboot.blog.dto.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler {
	// handle specific exceptions
	public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest){
		return null;
//		ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.);
		
	}
	
	//global exception
}
