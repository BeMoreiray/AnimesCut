package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.services.AnimesService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/animes")
public class AnimesController {
	
	
	@Autowired 
	AnimesService service;
	Animes result;
	
	 
	@GetMapping
	public List<Animes> getAllAnimes(){
		List<Animes> result = service.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Animes getAnimesById( @PathVariable Long id) {
		result = service.findById(id);
		return result;
	}
	
	@PostMapping
	public Animes insertAnimes(@Valid @RequestBody Animes anime) { 
		result = service.insertNewObject(anime);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAnimes(@PathVariable Long id, @RequestBody Animes updatedAnime) {
		Animes anime = service.findById(id);
		if(anime == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		anime.setTitle(updatedAnime.getTitle());
		anime.setLink(updatedAnime.getLink());
		anime.setReleaseYear(updatedAnime.getReleaseYear());
		anime.setDescription(updatedAnime.getDescription());
		anime.setStudio(updatedAnime.getStudio());
		anime.setCreator(updatedAnime.getCreator());
		
		 result = service.updateAnimes(id, anime);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o anime");
        }

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnimes(@PathVariable Long id){
		boolean deleted = service.deleteAnimesById(id);
		if(deleted) {
			return ResponseEntity.ok("Anime excluído com sucesso.");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/searchForAnimesNames")
	@ResponseBody
	public ResponseEntity<List<Animes>> searchAnimesByName(@RequestParam("title") String title){
		List<Animes> result = service.seacrhAnimesByTitle(title.trim().toUpperCase());
		
		if(result != null) {
		return  ResponseEntity.ok(result);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
