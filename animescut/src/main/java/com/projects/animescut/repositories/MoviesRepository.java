package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Long> {

}
