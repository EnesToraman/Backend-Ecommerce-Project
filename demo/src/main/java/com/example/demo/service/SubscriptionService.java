package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.dto.SubscriptionDto;
import com.example.demo.models.entitity.Subscription;
import com.example.demo.models.entitity.UserAgent;
import com.example.demo.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	
	private final SubscriptionRepository subscriptionRepository;
	
	@Autowired
	public SubscriptionService(SubscriptionRepository subscriptionRepository) {
		this.subscriptionRepository = subscriptionRepository;
	}
	
	public List<Subscription> getAllSubscriptions(){
		return this.subscriptionRepository.findAll();
	}

	public void addSubscription(SubscriptionDto subscriptionDto) {
		
		String userAgent = subscriptionDto.getUserAgent();
		String email = subscriptionDto.getEmail();

		Subscription subscription = new Subscription();
		UserAgent newUserAgent = new UserAgent();		
		
		Integer index1 = userAgent.indexOf(" ");
		Integer index2 = userAgent.indexOf("(");
		Integer index3 = userAgent.indexOf(";");
		Integer index4 = userAgent.indexOf(")");
		Integer index5 = userAgent.indexOf(")", index4);
		Integer index6 = userAgent.indexOf("/", index5);
		Integer index7 = userAgent.indexOf(" ", index6);
		
		String browser = userAgent.substring(0, index1);
		String device = userAgent.substring(index2 + 1, index3);
		String ip = userAgent.substring(index6 + 1, index7);
				
		newUserAgent.setBrowser(browser);
		newUserAgent.setDevice(device);
		newUserAgent.setIp(ip);
		
		subscription.setEmail(email);
		subscription.setUserAgent(newUserAgent);
		
		subscriptionRepository.save(subscription);
	}

}
