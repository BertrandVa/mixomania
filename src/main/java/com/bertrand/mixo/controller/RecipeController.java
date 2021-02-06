package com.bertrand.mixo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertrand.mixo.Exceptions.RecipeNotFoundException;
import com.bertrand.mixo.models.Recipe;
import com.bertrand.mixo.service.RecipeService;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {
	
	RecipeService service;
	
	@Autowired
	public RecipeController(RecipeService service) {
		this.service = service;
	}
	
	@GetMapping(value="/recipes")
    public List<Recipe> getAllRecipes(){
        return service.getAllRecipes();
    }  
	
	@GetMapping(value="/recipes/{id}")
    public Optional<Recipe> getRecipeById(@PathVariable("id") @Min(1) int id){
        return service.findById(id);
    }  
	
	@PostMapping(value="/recipes")
	public Recipe addRecipe(@Valid @RequestBody Recipe recipe) {
		return service.save(recipe);
	}

	@PutMapping(value="/recipes/{id}")
	public Recipe updateRecipe(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Recipe newRcp) {
		Recipe existingRecipe = this.service.findById(id)
											        .orElseThrow(()-> new RecipeNotFoundException("Recipe with id " + id + " not found"));
		existingRecipe.setIngredients(newRcp.getIngredients());
		existingRecipe.setPriceInCentsFor1Cl(newRcp.getPriceInCentsFor1Cl());
		existingRecipe.setName(newRcp.getName());
		return this.service.save(existingRecipe);
	}
	
	@DeleteMapping(value="/recipes/{id}")
	public String deleteIngredient(@PathVariable("id") @Min(1) int id) {
		Recipe existingRecipe = this.service.findById(id)
											     .orElseThrow(()-> new RecipeNotFoundException("Recipe with id " + id + " not found"));
		this.service.delete(existingRecipe.getId());
		return ("Recipe with id " + id + " deleted");
	}
}
