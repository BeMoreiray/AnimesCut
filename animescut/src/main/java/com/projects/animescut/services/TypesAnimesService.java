package com.projects.animescut.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.TypesAnimes;
import com.projects.animescut.repositories.TypesAnimesRepository;

@Service
@Validated
public class TypesAnimesService {
	
	@Autowired
	TypesAnimesRepository repository;
	
	public List<TypesAnimes> findAll(){
		List<TypesAnimes> result = repository.findAll();
		return result;
	}
	

}
