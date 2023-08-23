package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.TypesAnimes;
import com.projects.animescut.services.TypesAnimesService;

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
	
	
}
