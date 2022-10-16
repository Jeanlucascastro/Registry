package com.artrede.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artrede.registry.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
