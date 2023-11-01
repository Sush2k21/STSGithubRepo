package com.springboot.blog.service.Impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.dto.PostDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.CommentRepo;
import com.springboot.blog.repository.PostRepo;
import com.springboot.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public PostDto createPost(PostDto postDto) {
		//Convert DTO to entity
		Post post = modelMapper.map(postDto, Post.class);
//		Post post = new Post();
//		post.setTitle(postDto.getTitle());  
//		post.setDescription(postDto.getDescription());
//		post.setContent(postDto.getContent());
		Post newPost = postRepo.save(post);
		
		PostDto postResponse = mapToDto(newPost);
		return postResponse;
	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = postRepo.findAll();
		List<PostDto> getPosts = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
		return getPosts;
	}
	
	@Override
	public PostDto getPostById(long id) {
		Post post = postRepo.findById(id).orElseThrow();
		PostDto postReponse = mapToDto(post);
		return postReponse;
	}
	
	@Override
	public PostDto updatePost(PostDto postDto,long id) {
		Post post = postRepo.findById(id).orElseThrow();
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setDescription(postDto.getDescription());
		Post updatedPost = postRepo.save(post);
		PostDto postResponse = mapToDto(updatedPost);
		return postResponse;
	}
	
	@Override
	public void deletePost(long id) {
		Post post = postRepo.findById(id).orElseThrow();
		postRepo.delete(post);
	}
	
	// Convert Entity to DTO
	private PostDto mapToDto(Post post) {
//		PostDto postDto = modelMapper.map(post, PostDto.class);
		PostDto postDto = new PostDto();
		postDto.setId(post.getId());
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
		return postDto;
	}
}
