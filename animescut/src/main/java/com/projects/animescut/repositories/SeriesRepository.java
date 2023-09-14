package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {

}
