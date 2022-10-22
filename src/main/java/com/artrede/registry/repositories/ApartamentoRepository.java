package com.artrede.registry.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artrede.registry.entities.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{

}
