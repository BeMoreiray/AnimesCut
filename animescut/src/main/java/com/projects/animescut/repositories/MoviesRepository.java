package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Long> {
	Optional<Movies> findByAnimes(Animes animes);
}
