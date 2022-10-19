package com.artrede.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artrede.registry.entities.BudgetItem;

public interface BudgetItemRepository extends JpaRepository<BudgetItem, Long>{

}
