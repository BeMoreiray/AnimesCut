package com.projects.animescut.services;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message){
		super(message);
	}
}
