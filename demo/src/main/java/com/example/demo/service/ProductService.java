package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.entitity.Product;
import com.example.demo.models.entitity.Sales;
import com.example.demo.repository.BestSellingRepository;
import com.example.demo.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepository;
	
	private final BestSellingRepository bestSellingRepository;

	public List<Product> getAllProducts(){
		return this.productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return this.productRepository.findProductById(id);
	}
	
	public List<Product> getBestSellingProducts(){
		List<Long> productIds = this.bestSellingRepository.findTop3ByOrderByQuantityDesc()
				.stream()
				.map(Sales::getProductId)
				.toList();
		return (List<Product>) this.productRepository.findAllById(productIds);
	}
	
	public List<Product> getNewArrivals(){
		return this.productRepository.findTop3ByOrderByTimestampDesc();
	}

}
