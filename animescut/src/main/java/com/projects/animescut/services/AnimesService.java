package com.projects.animescut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;


@Service
public class AnimesService {
	
	@Autowired
	AnimesRepository repository;
	
	
	public List<Animes> findAll() {
		List<Animes> result =  repository.findAll();
		return result;
	}
	
	public Animes findById(Long id) {
		Animes result = repository.findById(id).get();
		return result;
		
	}
	
	public Animes insertNewObject(Animes anime) {
		Animes result = repository.save(anime);
		return result;
	}
	
	
	
}
