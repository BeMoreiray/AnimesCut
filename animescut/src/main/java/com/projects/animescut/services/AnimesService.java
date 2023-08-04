package com.projects.animescut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.repositories.AnimesRepository;

import jakarta.transaction.Transactional;


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
	
	@Transactional
	public Animes updateAnimes(Long id, String title, String link, int releaseYear, String description, String studio, String creator) {
		Animes result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setTitle(title);
			result.setLink(link);
			result.setReleaseYear(releaseYear);
			result.setDescription(description);
			result.setStudio(studio);
			result.setCreator(creator);
			
			return repository.save(result);
			
		}
		return null;
	}
	
	
}
