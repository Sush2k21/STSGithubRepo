package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.service.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

	@Autowired
	CommentService commentService;

	@PostMapping("/{postId}/create-comment")
	public ResponseEntity<CommentDto> createComment(@PathVariable long postId, @RequestBody CommentDto commentDto) {
		return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}

	@GetMapping("get-comment-by-postId/{postId}")
	public List<CommentDto> getCommentByPostId(@PathVariable long postId) {
		return commentService.getCommentByPostId(postId);
	}

	@GetMapping("get-comment-by-id/{postId}/{commentId}")
	public ResponseEntity<CommentDto> getCommentById(@PathVariable long postId, @PathVariable long commentId) {
		return ResponseEntity.ok(commentService.getCommentById(postId, commentId));
	}

	@PutMapping("update-comment-by-id/{postId}/{commentId}")
	public ResponseEntity<CommentDto> updateCommentById(@PathVariable long postId, @PathVariable long commentId,
			@RequestBody CommentDto commentDto) {
		return new ResponseEntity<>(commentService.updateCommentById(postId, commentId,commentDto),HttpStatus.CREATED);
	}
	
	@DeleteMapping("delete-comment-by-id/{postId}/{commentId}")
	public ResponseEntity<String> deleteCommentById(@PathVariable long postId, @PathVariable long commentId) {
		commentService.deleteCommentById(postId, commentId);
		return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
	}

}
