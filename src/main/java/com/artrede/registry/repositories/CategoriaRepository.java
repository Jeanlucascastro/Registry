package com.artrede.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artrede.registry.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
