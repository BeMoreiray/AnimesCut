package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.TypesAnimes;

public interface AnimesRepository extends JpaRepository<Animes, Long>{
	
	Animes findByTitle(String title);
 
}
