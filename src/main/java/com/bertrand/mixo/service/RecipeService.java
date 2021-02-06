package com.bertrand.mixo.service;

import java.util.List;
import java.util.Optional;

import com.bertrand.mixo.models.Recipe;

public interface RecipeService {
	List<Recipe> getAllRecipes();
	Optional<Recipe> findById(Integer id);
	Optional<Recipe> findByName(String name);
	Recipe save(Recipe recipe);
	void delete(Integer id);
}
