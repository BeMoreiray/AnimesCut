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

import com.projects.animescut.entities.TypesAnimes;
import com.projects.animescut.services.TypesAnimesService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/typesAnimes")
public class TypesAnimesController {
	
	@Autowired
	TypesAnimesService service;
	TypesAnimes result;
	
	@GetMapping
	public List<TypesAnimes> getAllTypes(){
		List<TypesAnimes> result = service.findAll();
		return result;
	}
	
	@GetMapping(value="/{id}")
	public TypesAnimes getTypesById(@PathVariable Long id) {
		result = service.findById(id);
		return result;
	}
	
	@PostMapping
	public TypesAnimes insertNewTypeAnimes(@RequestBody @Valid TypesAnimes types) {
		result = service.insertNewObject(types);
		return result;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateTypes(@PathVariable Long id, @RequestBody TypesAnimes updatedTypes) {
		//necessário???
		TypesAnimes typesAnimes = service.findById(id);
		if(typesAnimes == null) {
			return ResponseEntity.notFound().build();
		}
		//
		typesAnimes.setTitle(updatedTypes.getTitle());
		result = service.updateTypes(id, typesAnimes);
		
		if(result != null) {
			return ResponseEntity.ok(result);
		}else {
			//tentando uma nova forma de validação BAD_REQUEST (REFATORAÇÂO)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar o tipo de anime! Verifique se há algum campo em branco, e tente novamente!");
		}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTypes(@PathVariable Long id){
		boolean deleted = service.deleteTypesAnimes(id);
		if(deleted) {
			return ResponseEntity.ok("Tipo de anime excluido com sucesso!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
