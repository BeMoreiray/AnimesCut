package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;


@RestController
@RequestMapping(value = "/animes")
public class AnimesController {
	
	
	@Autowired 
	//private AnimesService service;
	private AnimesRepository repository;
	Animes result;
	 
	@GetMapping
	public List<Animes> getAllAnimes(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Animes getAnimesById(@PathVariable Long id) {
		
		result = repository.findById(id).get();
		return result;
		
		/*if(!service.isValidID(id)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de jogo inválido: " + id);
		}
		
		Animes result =  service.findById(id);
		return result;*/
	}
	
	@PostMapping
	public Animes insertAnimes(@RequestBody Animes anime) {
		result = repository.save(anime);
		return result;
	}
		
}
