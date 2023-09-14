package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.Series;
import com.projects.animescut.repositories.SeriesRepository;

@Service
public class SeriesService {
	@Autowired
	SeriesRepository repository;
	
	public List<Series> findAllSeries(){
		List<Series> result = repository.findAll();
		return result;
	};
	
	public Series findSeriesById(Long id) {
		Optional<Series> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Series de Anime não encontrado com o ID informado! Tente novamente");
		}
	}
	
	
}
