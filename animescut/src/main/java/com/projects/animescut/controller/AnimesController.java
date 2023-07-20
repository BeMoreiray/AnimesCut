package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;
import com.projects.animescut.services.AnimesService;

@RestController
public class AnimesController {
	
	
	@Autowired 
	private AnimesService service;
	private AnimesRepository repository;
	 
	@GetMapping(value = "/animes")
	public List<Animes> getAllAnimes(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/animes/{id}")
	public Animes getAnimesById(@PathVariable Long id) {
		if(!service.isValidID(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de jogo inválido: " + id);
		}
		
		Animes result =  service.findById(id);
		return result;
	}
		
}
