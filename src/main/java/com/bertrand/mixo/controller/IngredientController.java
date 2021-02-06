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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bertrand.mixo.Exceptions.IngredientNotFoundException;
import com.bertrand.mixo.models.Ingredient;
import com.bertrand.mixo.service.IngredientService;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
	
	IngredientService service;
	
	@Autowired
	public IngredientController(IngredientService service) {
		this.service = service;
	}
	
	@GetMapping(value="/ingredients")
    public List<Ingredient> getAllIngredients(){
        return service.getAllIngredients();
    }  
	
	@GetMapping(value="/ingredients/{id}")
    public Optional<Ingredient> getIngredientById(@PathVariable("id") @Min(1) int id){
        return service.findById(id);
    }  

	@PostMapping(value="/ingredients")
	public Ingredient addIngredient(@Valid @RequestBody Ingredient ingredient) {
		return service.save(ingredient);
	}

	@DeleteMapping(value="/ingredients/{id}")
	public String deleteIngredient(@PathVariable("id") @Min(1) int id) {
		Ingredient existingIngredient = this.service.findById(id)
											     .orElseThrow(()-> new IngredientNotFoundException("Ingredient with id " + id + " not found"));
		this.service.delete(existingIngredient.getId());
		return ("Ingredient with id " + id + " deleted");
	}
}
