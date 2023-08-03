package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.services.AnimesService;


@RestController
@RequestMapping(value = "/animes")
public class AnimesController {
	
	
	@Autowired 
	private AnimesService service;
	Animes result;
	 
	@GetMapping
	public List<Animes> getAllAnimes(){
		List<Animes> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Animes getAnimesById(@PathVariable Long id) {
		result = service.findById(id);
		return result;
	}
	
	@PostMapping
	public Animes saveAnimes(@RequestBody Animes anime) {
		result = service.insertNewObject(anime);
		return result;
	}
	
	
}
