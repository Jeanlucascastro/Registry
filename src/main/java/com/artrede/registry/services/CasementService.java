package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Casement;
import com.artrede.registry.repositories.CasementRepository;

@Service
public class CasementService {
	
	@Autowired
	private CasementRepository repository;
	
	public List<Casement> findAll() {
		return repository.findAll();
	}

	public Casement findById(Long id) {
		
		Optional<Casement> obj = repository.findById(id);
		
		return obj.get();
	}
	
	
}
