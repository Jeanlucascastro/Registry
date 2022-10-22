package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Categoria;
import com.artrede.registry.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public 	List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		
		return obj.get();
	}
	
	public Categoria insert(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}
	
	public void delete(Long id) {
		categoriaRepository.deleteById(id);
	}
	
	public Categoria updateCategoria(Categoria categoria, Categoria newCategoria) {
		categoria.setName(newCategoria.getName());
		return categoria;
	}
}
