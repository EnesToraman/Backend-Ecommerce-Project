package com.example.demo.models.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    
		private String name;
		
		private Long categoryId;
		
		private Double price;
		
		private String description;
		
		private String imageUrl;
		
		@CreationTimestamp
		private Date timestamp;

}