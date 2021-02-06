package com.bertrand.mixo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertrand.mixo.models.Ingredient;
import com.bertrand.mixo.persistence.IngredientRepository;
import com.bertrand.mixo.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {
	
	private IngredientRepository repo;
	
	@Autowired
	public IngredientServiceImpl(IngredientRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<Ingredient> getAllIngredients() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Ingredient> findById(Integer id) {
		return this.repo.findById(id);
	}

	@Override
	public Ingredient save(Ingredient ingredient) {
		return this.repo.save(ingredient);
	}

	@Override
	public void delete(Integer id) {
		this.repo.deleteById(id);
	}

}
