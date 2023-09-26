package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.Animes;

import com.projects.animescut.repositories.AnimesRepository;
import com.projects.animescut.repositories.TypesAnimesRepository;

import jakarta.transaction.Transactional;


@Service
@Validated 
public class AnimesService {
	
	@Autowired
	AnimesRepository repository;
	
	
	public List<Animes> findAll() {
		List<Animes> result =  repository.findAll();
		return result;
	}
	
	public Animes findById(Long id) {
		Optional<Animes> optionalAnime =  repository.findById(id);
		if(optionalAnime.isPresent()) {
			return optionalAnime.get();
		}else {
			throw new ResourceNotFoundException("Anime não encontrado com o ID informado! Tente novamente");
		}
		
		
	}
	
	public Animes insertNewObject(Animes anime/*, Long typesAnimesId*/) {
		/*TypesAnimes typesResult = typesRepository.findById(typesAnimesId);
		anime.setType(typesResult);*/
		Animes result = repository.save(anime);
		return result;
	}
	
	@Transactional
	public Animes updateAnimes(Long id, Animes anime) {
		Animes result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setTitle(anime.getTitle());
			result.setLink(anime.getLink());
			result.setReleaseYear(anime.getReleaseYear());
			result.setDescription(anime.getDescription());
			result.setStudio(anime.getStudio());
			result.setCreator(anime.getCreator());
		
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteAnimesById(Long id) {
		Animes result = findById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public List<Animes> seacrhAnimesByTitle(String title){
		return repository.findAnimesByTitle(title);
	}
	
	
}
