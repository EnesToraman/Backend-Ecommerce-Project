package com.example.demo.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entitity.User;
import com.example.demo.repository.UserRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
	public void addUser(UserDto userDto) {
		
		String email = userDto.getEmail();
		String password = hashPassword(userDto.getPassword());
		String isEmailAllowed = userDto.getIsEmailAllowed();

		User user = new User();
		
		user.setEmail(email);
		user.setPassword(password);
		user.setEmailAllowed(Boolean.parseBoolean(isEmailAllowed));
		
		userRepository.save(user);
	}
	
	private String hashPassword(String password){
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
}
