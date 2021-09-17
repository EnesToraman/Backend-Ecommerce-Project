package com.example.demo.models.entitity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Sales {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long saleId;
	
	private Long productId;
		
	private Long quantity;
	
}
