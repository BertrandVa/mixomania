package com.bertrand.mixo.service;

import java.util.List;
import java.util.Optional;

import com.bertrand.mixo.models.Alcohol;

public interface AlcoholService {
		List<Alcohol> getAllAlcohols();
		Optional<Alcohol> findById(Integer id);
		Optional<Alcohol> findByName(String name);
		Alcohol save(Alcohol alcohol);
		void deleteById(Integer id);		
}
