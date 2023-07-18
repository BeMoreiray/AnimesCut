package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.Animes;

public interface AnimesRepository extends JpaRepository<Animes, Long>{

}
