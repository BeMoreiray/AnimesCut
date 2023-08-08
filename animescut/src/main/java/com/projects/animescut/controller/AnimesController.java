package com.projects.animescut.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.services.AnimesService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/animes")
@Validated
public class AnimesController {
	
	
	@Autowired 
	private AnimesService service;
	Animes result;
	
	//Método auxiliar para executar a validação e obrigatoriedade de campos da classe Animes
	/*public ResponseEntity<Object> handleValidationErrors(BindingResult bindingResult){
		if (bindingResult.hasErrors()) {
            List<String> erros = bindingResult.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(erros);
        }
        return null; 
    
	}*/
	 
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
	public Animes saveAnimes(@Valid @RequestBody Animes anime,  BindingResult bindingResult) { 
		result = service.insertNewObject(anime);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> saveUpdate(@PathVariable Long id, @RequestBody Animes updatedAnime) {
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
		
		Animes result = service.updateAnimes(id, anime);
		
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
	
	
}
