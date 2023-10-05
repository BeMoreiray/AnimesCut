package com.projects.animescut.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projects.animescut.entities.AnimesWatched;
import com.projects.animescut.exceptions.ResourceNotFoundException;
import com.projects.animescut.repositories.AnimesWatchedRepository;

import jakarta.transaction.Transactional;

@Service
public class AnimesWatchedService {
	@Autowired
	AnimesWatchedRepository repository;
	
	public List<AnimesWatched> findAllAnimesWatched(){
		List<AnimesWatched> result = repository.findAll();
		return result;
	};
	
	public AnimesWatched findById(Long id) {
		Optional<AnimesWatched> optional =  repository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			throw new ResourceNotFoundException("Objeto não encontrado com o ID informado! Tente novamente");
		}
	}
	
	public AnimesWatched insertNewObject(AnimesWatched animesW) {
		AnimesWatched result = repository.save(animesW);
		return result;
	}
	
	@Transactional
	public AnimesWatched updateAnimesWatched(Long id, AnimesWatched animesW) {
		AnimesWatched result = repository.findById(id).orElse(null);
		if(result != null) {
			result.setUser(animesW.getUser());
			result.setAnimes(animesW.getAnimes());
			
			return repository.save(result);
			
		}
		return null;
	}
	
	@Transactional
	public boolean deleteAnimesWatchedById(Long id) {
		AnimesWatched result = this.findById(id);
		
		if(result != null) {
			repository.delete(result);
			return true;
		}
		return false;
		
	}
	
	public List<AnimesWatched> searchAnimesWatchedByUserId(Long userId){
		return repository.findAnimesWatchedByUserId(userId);
	}
	
}
