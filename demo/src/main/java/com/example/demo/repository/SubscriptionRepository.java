package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.entitity.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long>{

	public List<Subscription> findAll();
	
}
