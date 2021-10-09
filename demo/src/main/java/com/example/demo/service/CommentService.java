package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dto.CommentDto;
import com.example.demo.models.entity.Comment;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {

	private final CommentRepository commentRepository;
	
	@Autowired
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public List<Comment> getAllComments(){
		return this.commentRepository.findAll();
	}
	
	public void postComment(CommentDto commentDto) {
				
		String name = commentDto.getName();
		String email = commentDto.getEmail();
		String comment = commentDto.getComment();
		
		Comment newComment = new Comment();
		
		newComment.setName(name);
		newComment.setEmail(email);
		newComment.setComment(comment);
		
		commentRepository.save(newComment);
		
	}
}
