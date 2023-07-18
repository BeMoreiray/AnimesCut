package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;

@RestController
public class AnimesController {
	@Autowired 
	private AnimesRepository repository;
	 
	@GetMapping(value = "/animes")
	public List<Animes> getAllAnimes(){
		return repository.findAll();
	}

}
