package com.springboot.blog.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.dto.CommentDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.repository.CommentRepo;
import com.springboot.blog.repository.PostRepo;
import com.springboot.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepo commentRepo;

	@Autowired
	PostRepo postRepo;
	
	@Autowired 
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(long postId, CommentDto commentDto) {
		// Convert DTO to Entity
		Comment comment = modelMapper.map(commentDto, Comment.class);
		Post post = postRepo.findById(postId).orElseThrow();
//		comment.setId(commentDto.getId());
//		comment.setName(commentDto.getName());
//		comment.setEmail(commentDto.getEmail());
//		comment.setBody(commentDto.getBody());
		comment.setPost(post);
		Comment commentReponse = commentRepo.save(comment);

		CommentDto commentDtoReponse = mapToDto(commentReponse);
		return commentDtoReponse;
	}

	@Override
	public List<CommentDto> getCommentByPostId(long postId) {
		List<Comment> comment = commentRepo.findByPostId(postId);
		List<CommentDto> commentDtoList = comment.stream().map(var -> mapToDto(var)).collect(Collectors.toList());
		return commentDtoList;
	}

	@Override
	public CommentDto getCommentById(long postId, long commentId) {
		Post post = postRepo.findById(postId).orElseThrow();
		Comment comment = commentRepo.findById(commentId).orElseThrow();
		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to the post");
		}
		return mapToDto(comment);
	}

	@Override
	public CommentDto updateCommentById(long postId, long commentId, CommentDto commentDtoResp) {
		Post post = postRepo.findById(postId).orElseThrow();
		Comment comment = commentRepo.findById(commentId).orElseThrow();
		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to the post");
		}
		comment.setName(commentDtoResp.getName());
		comment.setEmail(commentDtoResp.getEmail());
		comment.setBody(commentDtoResp.getBody());
		Comment updatedComment = commentRepo.save(comment);

		return mapToDto(updatedComment);
	}
	
	@Override
	public void deleteCommentById(long postId, long commentId) {
		Post post = postRepo.findById(postId).orElseThrow();
		Comment comment = commentRepo.findById(commentId).orElseThrow();
		if (!comment.getPost().getId().equals(post.getId())) {
			throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to the post");
		}
		commentRepo.delete(comment);
	}

	// Convert Entity to DTO
	private CommentDto mapToDto(Comment comment) {
		CommentDto commentDto = modelMapper.map(comment, CommentDto.class);
//		CommentDto commentDto = new CommentDto();
//		commentDto.setId(comment.getId());
//		commentDto.setBody(comment.getBody());
//		commentDto.setName(comment.getName());
//		commentDto.setEmail(comment.getEmail());
		return commentDto;
	}

}
