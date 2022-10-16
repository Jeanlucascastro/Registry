package com.artrede.registry.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.services.BudgetService;

@RestController
@RequestMapping(value = "/budgets")
public class BudgetResource {
	
	@Autowired
	private BudgetService service;

	@GetMapping
	public ResponseEntity<List<Budget>> findAll() {
		
		List<Budget> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Budget> findById(@PathVariable Long id) {
		
		Budget obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
