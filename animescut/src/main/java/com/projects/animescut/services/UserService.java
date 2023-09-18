package com.projects.animescut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.User;
import com.projects.animescut.repositories.UserRepository;

@Service
@Validated
public class UserService {
	
	@Autowired
	UserRepository repository; 
	
	public List<User> findAllUsers(){
		List<User> result = repository.findAll();
		return result;
	}
}
