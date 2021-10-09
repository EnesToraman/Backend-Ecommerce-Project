package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>{
	
	public List<Comment> findAll();

}
