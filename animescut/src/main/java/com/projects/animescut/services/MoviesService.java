package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.Movies;
import com.projects.animescut.entities.Series;
import com.projects.animescut.repositories.MoviesRepository;

@Service
public class MoviesService {
	@Autowired
	MoviesRepository repository;
	
	public List<Movies> findAllMovies(){
		List<Movies> result = repository.findAll();
		return result;
	}
	
	public Movies findMoviesById(Long id) {
		Optional<Movies> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Filme de Animes não encontrado com o ID informado! Tente novamente");
		}
	}
}
