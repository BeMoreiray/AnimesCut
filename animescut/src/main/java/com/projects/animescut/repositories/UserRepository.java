package com.projects.animescut.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.animescut.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
