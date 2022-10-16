package com.artrede.registry.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_casement")
public class Casement implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double height;
	private Double width;
	private Double length;
	
	@Transient
	private Set<Category> categories = new HashSet<>();
	
	public Casement() {
		
	}



	public Casement(Long id, String name, String description, Double height, Double width, Double length) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.height = height;
		this.width = width;
		this.length = length;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Set<Category> getCategories() {
		return categories;
	}


	
	
	
}
