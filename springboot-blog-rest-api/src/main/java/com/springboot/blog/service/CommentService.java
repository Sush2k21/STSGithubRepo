package com.springboot.blog.service;

import java.util.List;

import com.springboot.blog.dto.CommentDto;

public interface CommentService {
	CommentDto createComment(long PostId, CommentDto commentDto);
	
	List<CommentDto> getCommentByPostId(long postId);
	
	CommentDto getCommentById(long postId,long commentId);
	
	CommentDto updateCommentById(long postId,long commentId,CommentDto commentDto);
	
	void deleteCommentById(long postId,long commentId);

}
