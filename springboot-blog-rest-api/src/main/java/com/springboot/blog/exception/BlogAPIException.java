package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class BlogAPIException extends RuntimeException{
	private HttpStatus status;
	private String message;
	public BlogAPIException(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
