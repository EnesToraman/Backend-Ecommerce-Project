package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	
	public List<Product> findAll();
	
	public Product findProductById(Long id);
	
	public List<Product> findTop3ByOrderByTimestampDesc();
	
}
