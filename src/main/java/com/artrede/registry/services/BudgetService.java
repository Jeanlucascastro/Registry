package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.repositories.BudgetRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository repository;
	
	public List<Budget> findAll() {
		return repository.findAll();
	}

	public Budget findById(Long id) {
		
		Optional<Budget> obj = repository.findById(id);
		
		return obj.get();
		
	}
}
