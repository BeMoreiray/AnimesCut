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
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.AnimesWatched;
import com.projects.animescut.entities.Favorites;
import com.projects.animescut.services.FavoritesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/favorites")
public class FavoritesController {
	
	@Autowired
	FavoritesService service;
	Favorites result;
	
	@GetMapping
	public List<Favorites> getAllFavorites(){
		List<Favorites> result = service.findAllFavorites();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Favorites getFavoritesById(@PathVariable Long id) {
		result = service.findById(id);
		return result;
	}
	
	@PostMapping
	public Favorites saveNewFavorites(@Valid @RequestBody Favorites favorites) {
		 result = service.insertNewObject(favorites);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateFavorites(@PathVariable Long id, @RequestBody Favorites updatedFavorites) {
		Favorites favorites = service.findById(id);
		if(favorites == null) {
			return ResponseEntity.notFound().build();
		}
		
		// Atualiza o anime com os valores fornecidos pelo objeto updateAnime
		favorites.setUser(updatedFavorites.getUser());
		favorites.setAnimes(updatedFavorites.getAnimes());
		
		 result = service.updateFavorites(id, favorites);
		
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar!");
        }

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAnimesWatched(@PathVariable Long id){
		boolean deleted = service.deleteAnimesWatchedById(id);
		if(deleted) {
			return ResponseEntity.ok("Exclusão feito com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
