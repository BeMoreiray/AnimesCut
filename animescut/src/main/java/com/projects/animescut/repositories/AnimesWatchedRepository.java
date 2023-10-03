package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.AnimesWatched;

public interface AnimesWatchedRepository extends JpaRepository<AnimesWatched, Long>{
	
}
