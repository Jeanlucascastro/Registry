package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.entities.Suite;
import com.artrede.registry.repositories.BudgetRepository;
import com.artrede.registry.repositories.SuiteRepository;

@Service
public class BudgetService {
	
	@Autowired
	private BudgetRepository repository;
	
	@Autowired
	private SuiteService suiteService;
	
	public List<Budget> findAll() {
		return repository.findAll();
	}

	public Budget findById(Long id) {
		
		Optional<Budget> obj = repository.findById(id);
		
		return obj.get();
	}
	
//	public Budget insert(Long id, Budget obj) {
//		Suite obj = suiteService.findById(id);
//		return repository.save();
//	}
}
