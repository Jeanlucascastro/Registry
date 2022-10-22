package com.artrede.registry.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Apartamento;
import com.artrede.registry.services.ApartamentoService;

@RestController
@RequestMapping(value = "/apartamentos")
public class ApartamentoResource {
	
	@Autowired
	private ApartamentoService apartamentoService;
	
	@GetMapping
	public ResponseEntity<List<Apartamento>> findAll(){
		List<Apartamento> list = apartamentoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Apartamento> findById(@PathVariable Long id) {
		Apartamento apto = apartamentoService.findById(id);
		return ResponseEntity.ok().body(apto);
	}
	
	@PostMapping
	public ResponseEntity<Apartamento> insert(@RequestBody Apartamento apto){
		apto = apartamentoService.insert(apto);
		return ResponseEntity.ok().body(apto);
	}
	@DeleteMapping
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		apartamentoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Apartamento> update(@PathVariable Long id, @RequestBody Apartamento apto) {
		apto = apartamentoService.update(id, apto);
		return ResponseEntity.ok().body(apto);
	}
	
}

