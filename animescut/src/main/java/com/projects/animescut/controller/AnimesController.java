package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> saveUpdate(@PathVariable Long id, @RequestBody Animes updateAnime) {
		Animes anime = service.findById(id);
		if(anime == null) {
			return ResponseEntity.notFound().build();
		}
		
		anime.setTitle(updateAnime.getTitle());
		anime.setLink(updateAnime.getLink());
		anime.setReleaseYear(updateAnime.getReleaseYear());
		anime.setDescription(updateAnime.getDescription());
		anime.setStudio(updateAnime.getStudio());
		anime.setCreator(updateAnime.getCreator());
		
		Animes result = service.updateAnimes(id, anime.getTitle(), 
				anime.getLink(), anime.getReleaseYear(), anime.getDescription(), 
				anime.getStudio(), anime.getCreator());
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o anime");
        }

	}
	
	
}
