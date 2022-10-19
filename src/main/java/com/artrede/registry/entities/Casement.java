package com.artrede.registry.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_casement")
public class Casement implements Serializable{
// product
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double height;
	private Double width;
	private Double length;
	
	@ManyToMany
	@JoinTable(name = "tb_casement_category", 
	joinColumns = @JoinColumn(name = "casement_id"),
	inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	@OneToMany(mappedBy = "id.casement")
	private Set<BudgetItem> items = new HashSet<>();
	
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

	@JsonIgnore
	public Set<Budget> getBudgets() {
		Set<Budget> set = new HashSet<>();
		for ( BudgetItem x : items) {
			set.add(x.getBudget());
		}
		return set;
	}


	@Override
	public int hashCode() {
		return Objects.hash(categories, description, height, id, length, name, width);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Casement other = (Casement) obj;
		return Objects.equals(categories, other.categories) && Objects.equals(description, other.description)
				&& Objects.equals(height, other.height) && Objects.equals(id, other.id)
				&& Objects.equals(length, other.length) && Objects.equals(name, other.name)
				&& Objects.equals(width, other.width);
	}


	
	
	
}
