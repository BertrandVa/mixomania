package com.bertrand.mixo.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bertrand.mixo.models.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient,Integer> {

	Optional<Ingredient> findById(Integer id);
	
}
