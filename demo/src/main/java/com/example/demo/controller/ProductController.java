package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.entity.Product;
import com.example.demo.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	private final ProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@GetMapping("/product")
	public Product getProductById(@RequestParam Long id) {
		return this.productService.getProductById(id);
	}
	
	@GetMapping("/best-selling-products")
	public List<Product> getBestSellingProducts(){
		return this.productService.getBestSellingProducts();
	}
	
	@GetMapping("/new-arrivals")
	public List<Product> getNewArrivals() {
		return this.productService.getNewArrivals();
	}
	
}