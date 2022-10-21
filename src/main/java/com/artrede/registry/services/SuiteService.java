package com.artrede.registry.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.artrede.registry.entities.Suite;
import com.artrede.registry.repositories.SuiteRepository;

@Service
public class SuiteService {

	@Autowired
	private SuiteRepository repository;

	public List<Suite> findAll() {
		return repository.findAll();
	}

	public Suite findById(Long id) {

		Optional<Suite> obj = repository.findById(id);

		return obj.get();
	}

	public Suite insert(Suite obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Suite update(Long id, Suite obj) {
		Suite entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Suite entity, Suite obj) {
		entity.setName(obj.getName());
		entity.setAddress(obj.getAddress());
		entity.setPhone(obj.getPhone());
	}
}
