package com.bertrand.mixo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.persistence.AlcoholRepository;
import com.bertrand.mixo.service.AlcoholService;

@Service
public class AlcoholServiceImpl implements AlcoholService {
	
	private AlcoholRepository alcRepo;
	
	@Autowired
	public AlcoholServiceImpl(AlcoholRepository repo) {
		this.alcRepo = repo;
	}
	
	@Override
	public List<Alcohol> getAllAlcohols() {
		return this.alcRepo.findAll();
	}

	@Override
	public Optional<Alcohol> findById(Integer id) {
		return this.alcRepo.findById(id);
	}

	@Override
	public Optional<Alcohol> findByName(String name) {
		return this.alcRepo.findByName(name);
	}

	@Override
	public Alcohol save(Alcohol alcohol) {
		return this.alcRepo.save(alcohol);
	}

	@Override
	public void deleteById(Integer id) {
		this.alcRepo.deleteById(id);
	}	

}
