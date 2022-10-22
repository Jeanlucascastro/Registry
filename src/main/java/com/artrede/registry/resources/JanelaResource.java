package com.artrede.registry.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Janela;
import com.artrede.registry.services.JanelaService;

@RestController
@RequestMapping(value = "/janelas")
public class JanelaResource {
	
	@Autowired
	private JanelaService janelaService;
	
	@GetMapping
	public ResponseEntity<List<Janela>> findAll(){
		List<Janela> list = janelaService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Janela> insert(@PathVariable Long id, @RequestBody Janela janela) {
		janela = janelaService.insert(id, janela);
		return ResponseEntity.ok().body(janela);
	}
	

}
