package com.artrede.registry.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.artrede.registry.entities.Suite;

@RestController
@RequestMapping(value = "/suites")
public class SuiteResource {

	@GetMapping
	public ResponseEntity<Suite> findAll() {
		Suite s = new Suite(1L, "sienna", "av airton senna", "3342");
		return ResponseEntity.ok().body(s);
	}
}
