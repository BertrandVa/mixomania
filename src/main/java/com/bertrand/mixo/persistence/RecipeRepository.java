package com.bertrand.mixo.persistence;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe,Integer> {

	List<Recipe> findByIngredients(Map<Alcohol,Integer> ingredients);
	Optional<Recipe> findById(Integer id);
	Optional<Recipe> findByName(String name);
}
