package com.springboot.blog.dto;

import lombok.Data;

@Data
public class CommentDto {
	private Long Id;
	private String name;
	private String email;
	private String body;
}
