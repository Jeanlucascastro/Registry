package com.artrede.registry.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

import com.artrede.registry.entities.Suite;
import com.artrede.registry.repositories.SuiteRepository;

@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private SuiteRepository suiteRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Suite suite = new Suite(null, "sienna", "av airton senna", "3342");
		Suite suite2 = new Suite(null, "penna", "av airton senna", "3342");
		
		suiteRepository.saveAll(Arrays.asList(suite, suite2));
	}
}
