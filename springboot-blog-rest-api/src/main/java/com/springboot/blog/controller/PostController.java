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

import com.springboot.blog.dto.PostDto;
import com.springboot.blog.service.PostService;

@RestController
@RequestMapping("/api/blog")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create-post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		return new ResponseEntity<>(postService.createPost(postDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/get-post")
	public List<PostDto> getAllPosts(){
		return postService.getAllPosts();	
	}
	
	@GetMapping("get-post-by-id/{get-post-by-id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name= "get-post-by-id") long id){
		return ResponseEntity.ok(postService.getPostById(id));	
	}
	
	@PutMapping("update-post-by-id/{update-post-by-id}")
	public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto, @PathVariable(name= "update-post-by-id") long id){
		return new ResponseEntity<>(postService.updatePost(postDto,id),HttpStatus.OK);	
	}
	
	@DeleteMapping("delete-post-by-id/{delete-post-by-id}")
	public ResponseEntity<String> deletePostById(@PathVariable(name= "delete-post-by-id") long id){
		postService.deletePost(id);
		return new ResponseEntity<>("Post has deleted successfully",HttpStatus.OK);	
	}

}
