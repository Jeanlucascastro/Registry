package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Apartamento;
import com.artrede.registry.repositories.ApartamentoRepository;

@Service
public class ApartamentoService {
	
	@Autowired
	private ApartamentoRepository apartamentoRepository;

	public List<Apartamento> findAll() {
		return apartamentoRepository.findAll();
	}
	
	public Apartamento findById(Long id) {
		Optional<Apartamento> apto = apartamentoRepository.findById(id);
		return apto.get();
	}
	
	public Apartamento insert(Apartamento apartamento) {
		return apartamentoRepository.save(apartamento);
	}
	
	public void delete(Long id) {
		apartamentoRepository.deleteById(id);
	}
	
	public Apartamento update(Long id, Apartamento newApto) {
		Apartamento oldApto = apartamentoRepository.getReferenceById(id);
		updateApto(oldApto, newApto);
		return apartamentoRepository.save(oldApto);
		
	}
	
	private void updateApto(Apartamento oldApto, Apartamento newApto) {
		oldApto.setName(newApto.getName());
		oldApto.setAddress(newApto.getAddress());
		oldApto.setPhone(newApto.getPhone());
	}
	
}
