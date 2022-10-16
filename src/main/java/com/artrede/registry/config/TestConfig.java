package com.artrede.registry.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.entities.Casement;
import com.artrede.registry.entities.Category;
import com.artrede.registry.entities.Suite;
import com.artrede.registry.entities.enums.BudgetStatus;
import com.artrede.registry.repositories.BudgetRepository;
import com.artrede.registry.repositories.CasementRepository;
import com.artrede.registry.repositories.CategoryRepository;
import com.artrede.registry.repositories.SuiteRepository;

@Configuration
//@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private SuiteRepository suiteRepository;
	
	@Autowired
	private BudgetRepository budgetRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CasementRepository casementRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Suite suite = new Suite(null, "sienna", "av airton senna", "3342");
		Suite suite2 = new Suite(null, "penna", "av airton senna", "3342");
		
		suiteRepository.saveAll(Arrays.asList(suite, suite2));
		
		Budget budget1 = new Budget(null, Instant.parse("2022-06-20T19:53:07Z"),BudgetStatus.PENDENT,  "maria", "33433783", suite);
		Budget budget2 = new Budget(null, Instant.parse("2022-07-21T03:42:10Z"), BudgetStatus.PENDENT, "pedro", "9999999" ,suite2);
		Budget budget3 = new Budget(null, Instant.parse("2022-07-22T15:21:22Z"), BudgetStatus.PENDENT, "joao", "888888", suite); 
		
		budgetRepository.saveAll(Arrays.asList(budget1, budget2, budget3));
		
		Category cat1 = new Category(null, "Casa");
		Category cat2 = new Category(null, "Apartamento");
		Category cat3 = new Category(null, "Quadra"); 
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		Casement case1 = new Casement(null, "janelafrontal", "sacada", 1.90, 2.00, 3.00);
		Casement case2 = new Casement(null, "janelalateral", "quarto", 1.90, 2.00, 3.00);
		Casement case3 = new Casement(null, "janelalado", "quarto 2", 1.90, 2.00, 3.00);
		
		casementRepository.saveAll(Arrays.asList(case1, case2, case3));
		
	}
}
