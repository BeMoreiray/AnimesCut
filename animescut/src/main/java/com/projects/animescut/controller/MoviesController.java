package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Movies;
import com.projects.animescut.services.MoviesService;

@RestController
@RequestMapping(value = "/movies")
public class MoviesController {
	@Autowired
	MoviesService service;
	
	@GetMapping
	public List<Movies> getAllMovies(){
		List<Movies> result = service.findAllMovies();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Movies getMoviesById(@PathVariable Long id) {
		Movies result = service.findMoviesById(id);
		return result;
	}
}
