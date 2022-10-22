package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Apartamento;
import com.artrede.registry.entities.Janela;
import com.artrede.registry.repositories.JanelaRepository;


@Service
public class JanelaService {
	
	@Autowired
	private JanelaRepository janelaRepository;
	
	@Autowired
	private ApartamentoService apartamentoService;
	
	

	public List<Janela> findAll() {
		return janelaRepository.findAll();
	}
	
	public Janela findById(Long id) {
		Optional<Janela> janela = janelaRepository.findById(id);
		return janela.get();
	}
	
	public Janela insert(Long id, Janela janela) {
		Apartamento apartamento = apartamentoService.findById(id);
		janela.setApartamento(apartamento);
		return janelaRepository.save(janela);
	}
	
	public void delete(Long id) {
		janelaRepository.deleteById(id);
	}
	
//	public Janela update(Long id, Janela newApto) {
//		Janela oldApto = janelaRepository.getReferenceById(id);
//		updateApto(oldApto, newApto);
//		return JanelaRepository.save(oldApto);
//		
//	}
	
//	private void updateApto(Janela oldApto, Janela newApto) {
//		oldApto.setName(newApto.getName());
//		oldApto.setAddress(newApto.getAddress());
//		oldApto.setPhone(newApto.getPhone());
//	}
	
}
