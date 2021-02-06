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

import com.bertrand.mixo.Exceptions.BottleNotFoundException;
import com.bertrand.mixo.models.Bottle;
import com.bertrand.mixo.service.BottleService;

@RestController
@RequestMapping("/api/bottle")
public class BottleController {
	
	BottleService service;
	
	@Autowired
	public BottleController(BottleService service) {
		this.service = service;
	}
	
	@GetMapping(value="/bottles")
    public List<Bottle> getAllBottles(){
        return service.getAllBottles();
    }  
	
	@GetMapping(value="/bottles/{id}")
    public Optional<Bottle> getBottleById(@PathVariable("id") @Min(1) int id){
        return service.findById(id);
    }  
	
	@GetMapping(value="/bottlesbybrand/{brand}")
    public Optional<Bottle> getBottleByBrand(@PathVariable("brand") String brand){
        return service.findByBrand(brand);
    } 
	
	@GetMapping(value="/bottlesbyalcohol/{alcohol}")
    public List<Bottle> getBottlesByAlcohol(@PathVariable("alcohol") Integer alcoholId){
        return service.findByAlcohol(alcoholId);
    } 

	@PostMapping(value="/bottles")
	public Bottle addBottle(@Valid @RequestBody Bottle bottle) {
		return service.save(bottle);
	}

	@PutMapping(value="/bottles/{id}")
	public Bottle updateBottle(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Bottle newBtl) {
		Bottle existingBottle = this.service.findById(id)
											.orElseThrow(()-> new BottleNotFoundException("Bottle with id " + id + " not found"));
		existingBottle.setBrand(newBtl.getBrand());
		existingBottle.setAlcohol(newBtl.getAlcohol());
		existingBottle.setNumber(newBtl.getNumber());
		existingBottle.setPriceInCentsFor1Cl(newBtl.getPriceInCentsFor1Cl());
		existingBottle.setVolume(newBtl.getVolume());
		return this.service.save(existingBottle);
	}
	
	@DeleteMapping(value="/bottles/{id}")
	public String deleteBottle(@PathVariable("id") @Min(1) int id) {
		Bottle existingBottle = this.service.findById(id)
											.orElseThrow(()-> new BottleNotFoundException("Bottle with id " + id + " not found"));
		this.service.deleteById(existingBottle.getId());
		return ("Bottle with id " + id + " deleted");
	}
}
