package com.projects.animescut.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.TypesAnimes;
import com.projects.animescut.repositories.TypesAnimesRepository;

@Service
@Validated //anotação utilizada para auxiliar @notnull e @notBlank, permite que a validação seja feita
public class TypesAnimesService {
	
	@Autowired
	TypesAnimesRepository repository;
	
	public List<TypesAnimes> findAll(){
		List<TypesAnimes> result = repository.findAll();
		return result;
	}
	
	public TypesAnimes findById(Long id) {
		Optional<TypesAnimes> optionalTypesAnimes = repository.findById(id);
		if(optionalTypesAnimes.isPresent()) {
			return optionalTypesAnimes.get();
		}else {
			throw new ResourceNotFoundException("Categoria de anime não encontrada com o ID informado! Tente novamente");
		}
	}
	
	public TypesAnimes insertNewObject(TypesAnimes types) {
		TypesAnimes result = repository.save(types);
		return result;
	}
}
