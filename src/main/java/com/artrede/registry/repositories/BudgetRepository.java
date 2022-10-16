package com.artrede.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artrede.registry.entities.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long>{

}
