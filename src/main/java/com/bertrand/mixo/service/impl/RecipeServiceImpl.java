package com.bertrand.mixo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertrand.mixo.models.Recipe;
import com.bertrand.mixo.persistence.RecipeRepository;
import com.bertrand.mixo.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {
	
	private RecipeRepository repo;
	
	@Autowired
	public RecipeServiceImpl(RecipeRepository rep) {
		this.repo = rep;
	}

	@Override
	public List<Recipe> getAllRecipes() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Recipe> findById(Integer id) {
		return this.repo.findById(id);
	}

	@Override
	public Optional<Recipe> findByName(String name) {
		return this.repo.findByName(name);
	}

	@Override
	public Recipe save(Recipe recipe) {
		return this.repo.save(recipe);
	}

	@Override
	public void delete(Integer id) {
		this.repo.deleteById(id);

	}

}
