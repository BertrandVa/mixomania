package com.bertrand.mixo.service;

import java.util.List;
import java.util.Optional;

import com.bertrand.mixo.models.Ingredient;

public interface IngredientService {
	List<Ingredient> getAllIngredients();
	Optional<Ingredient> findById(Integer id);
	Ingredient save(Ingredient ingredient);
	void delete(Integer id);
}
