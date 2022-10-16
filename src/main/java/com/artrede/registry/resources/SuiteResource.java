package com.artrede.registry.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Suite;
import com.artrede.registry.services.SuiteService;

@RestController
@RequestMapping(value = "/suites")
public class SuiteResource {
	
	@Autowired
	private SuiteService service;

	@GetMapping
	public ResponseEntity<List<Suite>> findAll() {
		
		List<Suite> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Suite> findById(@PathVariable Long id) {
		
		Suite obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
