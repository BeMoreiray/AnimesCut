package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Series;
import com.projects.animescut.repositories.SeriesRepository;

import jakarta.transaction.Transactional;

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
	
	public Series insertNewObject(Series serie) {
		Series result = repository.save(serie);
		return result;
	}
	
	@Transactional
	public Series updateSeries(Long id, Series series) {
		Series result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setNumberEpisodes(series.getNumberEpisodes());
			result.setNumberSeasons(series.getNumberSeasons());
			result.setAnimes(series.getAnimes());
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteSeriesById(Long id) {
		Series result = findSeriesById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	
}
