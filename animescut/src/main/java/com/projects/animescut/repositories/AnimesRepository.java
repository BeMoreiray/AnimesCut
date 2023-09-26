package com.projects.animescut.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projects.animescut.entities.Animes;

public interface AnimesRepository extends JpaRepository<Animes, Long>{
	
	@Query(value = "select a from Animes a where a.title like %?1% ")
	List<Animes> findAnimesByTitle(String title);
 
}
