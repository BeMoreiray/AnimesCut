package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.User;
import com.projects.animescut.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Validated
public class UserService {
	
	@Autowired
	UserRepository repository; 
	
	public List<User> findAllUsers(){
		List<User> result = repository.findAll();
		return result;
	}
	

	public User findUsersById(Long id) {
		Optional<User> optional = repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Usuário não encontrado!");
		}
	}
	
	public User insertNewUserObject(User user) {
		User result = repository.save(user);
		return result;
	}
	
	@Transactional
	public User updateUser(Long id, User user) {
		User result = repository.findById(id).orElse(user);
		if(result != null) {
			result.setUserName(user.getUserName());
			result.setEmail(user.getEmail());
			result.setPassword(user.getPassword());
			
			return repository.save(result);
		}
		return null;
	}
}
