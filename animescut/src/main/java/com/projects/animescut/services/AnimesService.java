package com.projects.animescut.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;


@Service
public class AnimesService {
	
	@Autowired
	AnimesRepository repository;
	
	public boolean isValidID(Long id) {
		return repository.findById(id).isPresent();
	}
	
	@Transactional(readOnly = true)
	public Animes findById(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Anime não encontrado com id: " + id));	
		
	}
}
