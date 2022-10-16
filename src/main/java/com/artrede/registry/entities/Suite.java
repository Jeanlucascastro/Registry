package com.artrede.registry.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "tb_suite")
public class Suite implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 private String name;
	 private String address;
	 private String phone;
	 
	@JsonIgnore
	@OneToMany(mappedBy = "place")
	private List<Budget> budgets = new ArrayList<>();
	

	
	public Suite() {
		
	}
	
	public Suite(Long id, String name, String address, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Budget> getBudgets() {
		return budgets;
	}


	
}
