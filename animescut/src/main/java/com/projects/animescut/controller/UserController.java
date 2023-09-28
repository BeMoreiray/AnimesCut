package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.User;
import com.projects.animescut.services.UserService;

import jakarta.validation.Valid;

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
	
	@GetMapping(value = "/{id}")
	public User getUsersById(@PathVariable Long id) {
		result = service.findUsersById(id);
		return result;
	}
	
	@PostMapping
	public User saveNewUser(@Valid @RequestBody User user) {
		result = service.insertNewUserObject(user);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody User userUpdated){
		User user = service.findUsersById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		user.setUserName(userUpdated.getUserName());
		user.setEmail(userUpdated.getEmail());
		user.setPassword(userUpdated.getPassword());
		
		result = service.updateUser(id, user);
		
		if(result != null) {
			return ResponseEntity.ok(result + "usuário atualizado!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("erro ao atualizar usuário! tente novamente.");
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		boolean deleted = service.deleteUserById(id);
		if(deleted) {
			return ResponseEntity.ok("Usuário excluído com sucesso!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping(value="/login")
	public String authenticateUserLogin(@RequestParam String email,@RequestParam String password){
		User user = service.authenticate(email, password);
		if(user != null) {
			return "Login feito com suceso!";
		}else {
			return "Login inválido, tente novamente!";
		}
	}
	
	
	
	
	
}
