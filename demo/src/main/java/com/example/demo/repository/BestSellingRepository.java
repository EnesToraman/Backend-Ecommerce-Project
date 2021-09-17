package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entitity.Sales;

public interface BestSellingRepository extends JpaRepository<Sales, Long>{
	
	public List<Sales> findTop3ByOrderByQuantityDesc();

}
