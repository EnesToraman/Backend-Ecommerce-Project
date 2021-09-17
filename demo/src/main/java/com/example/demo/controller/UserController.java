package com.example.demo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.dto.UserDto;
import com.example.demo.models.entitity.User;
import com.example.demo.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	private final UserService userService;
	
	@RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }
	
	@GetMapping("/user")
	public List<User> getUser() {
		return this.userService.getAllUsers();
	}
	
	@PostMapping("/user")
	public void addUser(@RequestBody UserDto userDto) {
		this.userService.addUser(userDto);
	}
	

}
