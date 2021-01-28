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

import com.bertrand.mixo.Exceptions.AlcoholNotFoundException;
import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.service.AlcoholService;

@RestController
@RequestMapping("/api/alcohol")
public class AlcoholController {
	
	AlcoholService service;
	
	@Autowired
	public AlcoholController(AlcoholService service) {
		this.service = service;
	}
	
	@GetMapping(value="/alcohols")
    public List<Alcohol> getAllAlcohols(){
        return service.getAllAlcohols();
    }  
	
	@GetMapping(value="/alcohols/{id}")
    public Optional<Alcohol> getAlcoholById(@PathVariable("id") @Min(1) int id){
        return service.findById(id);
    }  

	@PostMapping(value="/alcohols")
	public Alcohol addAlcohol(@Valid @RequestBody Alcohol alcohol) {
		return service.save(alcohol);
	}

	@PutMapping(value="/alcohols/{id}")
	public Alcohol updateAlcohol(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Alcohol newAlc) {
		Alcohol existingAlcohol = this.service.findById(id)
											  .orElseThrow(()-> new AlcoholNotFoundException("Alcohol with id " + id + " not found"));
		existingAlcohol.setName(newAlc.getName());
		return this.service.save(existingAlcohol);
	}
	
	@DeleteMapping(value="/alcohols/{id}")
	public String deleteAlcohol(@PathVariable("id") @Min(1) int id) {
		Alcohol existingAlcohol = this.service.findById(id)
											  .orElseThrow(()-> new AlcoholNotFoundException("Alcohol with id " + id + " not found"));
		this.service.deleteById(existingAlcohol.getId());
		return ("Student with id " + id + " deleted");
	}
}
