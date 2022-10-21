package com.artrede.registry.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;

import com.artrede.registry.entities.Budget;
import com.artrede.registry.entities.BudgetItem;
import com.artrede.registry.entities.Casement;
import com.artrede.registry.entities.Category;
import com.artrede.registry.entities.Payment;
import com.artrede.registry.entities.Suite;
import com.artrede.registry.entities.enums.BudgetStatus;
import com.artrede.registry.repositories.BudgetItemRepository;
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
	
	@Autowired
	private BudgetItemRepository budgetItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Suite suite = new Suite(null, "sienna", "av airton senna", "3342");
		Suite suite2 = new Suite(null, "penna", "av airton senna", "3342");
		
		suiteRepository.saveAll(Arrays.asList(suite, suite2));
		
		Budget budget1 = new Budget(null, Instant.parse("2022-06-20T19:53:07Z"),BudgetStatus.DONE,  "maria", "33433783", suite);
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
		
		case1.getCategories().add(cat2);
		case2.getCategories().add(cat1);
		case2.getCategories().add(cat3);
		case3.getCategories().add(cat3);
		
		casementRepository.saveAll(Arrays.asList(case1, case2, case3));
		
		BudgetItem oi1 = new BudgetItem(budget1, case1, 2, case1.getLength());
		BudgetItem oi2 = new BudgetItem(budget1, case3, 1, case3.getLength());
		BudgetItem oi3 = new BudgetItem(budget2, case3, 2, case3.getLength());
		BudgetItem oi4 = new BudgetItem(budget2, case2, 2, case2.getLength()); 
		
		budgetItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2022-06-20T21:53:07Z"), budget1 );
		
		budget1.setPayment(pay1);
		budgetRepository.save(budget1);
		
	}
}
