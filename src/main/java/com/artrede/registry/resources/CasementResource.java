package com.artrede.registry.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Casement;
import com.artrede.registry.services.CasementService;

@RestController
@RequestMapping(value = "/casements")
public class CasementResource {
	
	@Autowired
	private CasementService service;

	@GetMapping
	public ResponseEntity<List<Casement>> findAll() {
		
		List<Casement> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Casement> findById(@PathVariable Long id) {
		
		Casement obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
}
