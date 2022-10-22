package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Apartamento;
import com.artrede.registry.entities.Orcamento;
import com.artrede.registry.repositories.OrcamentoRepository;

@Service
public class OrcamentoService {

	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private ApartamentoService apartamentoService;
	
	public List<Orcamento> findAll() {
		return orcamentoRepository.findAll();
	}
	
	public Orcamento findById(Long id) {
		Optional<Orcamento> orcamento = orcamentoRepository.findById(id);
		return orcamento.get();
	}
	
	public Orcamento insert(Long id, Orcamento orcamento) {
		Apartamento apartamento = apartamentoService.findById(id);
		orcamento.setApartamento(apartamento);
		return orcamentoRepository.save(orcamento);
	}
	
	public void delete(Long id) {
		orcamentoRepository.deleteById(id);
	}
	
	public Orcamento update(Long id, Orcamento newOrcamento) {
		Orcamento orcamento = orcamentoRepository.getReferenceById(id);
		updateOrcamento(orcamento, newOrcamento);
		return orcamentoRepository.save(orcamento);
		
	}
	
	public void updateOrcamento(Orcamento orcamento, Orcamento newOrcamento) {
		orcamento.setPreco(newOrcamento.getPreco());
	}
}
