package com.projects.animescut.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Animes;
import com.projects.animescut.entities.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	 Optional<Series> findByAnimes(Animes animes);
}
