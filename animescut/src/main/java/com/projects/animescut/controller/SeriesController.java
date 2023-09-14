package com.projects.animescut.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projects.animescut.entities.Series;
import com.projects.animescut.services.SeriesService;

@RestController
@RequestMapping(value = "/series")
public class SeriesController {
	
	@Autowired
	SeriesService service;
	
	@GetMapping
	public List<Series> getAllSeries(){
		List<Series> result = service.findAllSeries();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Series getSeriesById(@PathVariable Long id) {
		Series result = service.findSeriesById(id);
		return result;
	}
	
}
