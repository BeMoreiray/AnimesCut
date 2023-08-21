package com.projects.animescut.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="tb_typeAnimes")
public class TypesAnimes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="title")
	@NotBlank(message = "Titulo de tipos obrigatório")
	private String title_type;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title_type;
	}
	public void setTitle(String title) {
		this.title_type = title;
	}
	
	
}
