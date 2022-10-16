package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Suite;
import com.artrede.registry.repositories.SuiteRepository;

@Service
public class SuiteService {
	
	@Autowired
	private SuiteRepository repository;
	
	public List<Suite> findAll() {
		return repository.findAll();
	}

	public Suite findById(Long id) {
		
		Optional<Suite> obj = repository.findById(id);
		
		return obj.get();
		
	}
}
