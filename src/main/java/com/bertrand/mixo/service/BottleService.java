package com.bertrand.mixo.service;

import java.util.List;
import java.util.Optional;

import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.models.Bottle;

public interface BottleService {
		List<Bottle> getAllBottles();
		Optional<Bottle> findById(Integer id);
		Optional<Bottle> findByBrand(String brand);
		List<Bottle> findByAlcohol(Alcohol alcohol);
		Bottle save(Bottle bottle);
		void deleteById(Integer id);		
}
