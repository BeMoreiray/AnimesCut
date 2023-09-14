package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Animes;

public interface AnimesRepository extends JpaRepository<Animes, Long>{
	
	Animes findByTitle(String title);
 
}
