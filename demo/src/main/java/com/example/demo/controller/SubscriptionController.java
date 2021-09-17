package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.SubscriptionDto;
import com.example.demo.models.entitity.Subscription;
import com.example.demo.service.SubscriptionService;

import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
public class SubscriptionController {
	
	private final SubscriptionService subscriptionService;
			
	@GetMapping("/subscription")
	public List<Subscription> getAllSubscriptions() {
		return this.subscriptionService.getAllSubscriptions();
	}
	
	@PostMapping("/subscription")
	public void addSubscription(@RequestBody SubscriptionDto subscriptionDto) {
		this.subscriptionService.addSubscription(subscriptionDto);
	}

}
