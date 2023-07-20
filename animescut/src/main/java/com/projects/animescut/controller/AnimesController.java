package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;

@RestController
@RequestMapping(value = "/animes")
public class AnimesController {
	@Autowired 
	private AnimesRepository repository;
	 
	@GetMapping
	public List<Animes> getAllAnimes(){
		return repository.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Animes getById(@PathVariable Long id) {
		return repository.findById(id).get();
	}

}
