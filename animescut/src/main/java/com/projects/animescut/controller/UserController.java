package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.User;
import com.projects.animescut.services.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService service;
	User result;
	
	@GetMapping
	public List<User> getAllUsers(){
		List<User> result = service.findAllUsers();
		return result;
	}
	
	
	
}
