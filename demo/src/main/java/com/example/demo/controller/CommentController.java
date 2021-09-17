package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.CommentDto;
import com.example.demo.models.entitity.Comment;
import com.example.demo.service.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	private final CommentService commentService;
	
	@Autowired
	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping("/comments")
	public List<Comment> getAllComments(){
		return this.commentService.getAllComments();
	}
	
	@PostMapping("/comments")
	public void postComment(@RequestBody CommentDto commentDto) {
		this.commentService.postComment(commentDto);
	}

}
