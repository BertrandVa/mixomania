package com.bertrand.mixo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.models.Bottle;
import com.bertrand.mixo.persistence.AlcoholRepository;
import com.bertrand.mixo.persistence.BottleRepository;
import com.bertrand.mixo.service.BottleService;

@Service
public class BottleServiceImpl implements BottleService {
	
	private AlcoholRepository alc;
	private BottleRepository repo;
	
	@Autowired
	public BottleServiceImpl(BottleRepository repo, AlcoholRepository alc) {
		this.repo = repo;
		this.alc = alc;
	}
	
	@Override
	public List<Bottle> getAllBottles() {
		return this.repo.findAll();
	}

	@Override
	public Optional<Bottle> findById(Integer id) {
		return this.repo.findById(id);
	}

	@Override
	public Optional<Bottle> findByBrand(String brand) {
		return this.repo.findByBrand(brand);
	}

	@Override
	public List<Bottle> findByAlcohol(Alcohol alcohol) {
		return this.repo.findByAlcohol(alcohol);
	}

	@Override
	public Bottle save(Bottle bottle) {
		Optional<Alcohol> alcohol = this.alc.findById(bottle.getAlcohol().getId());
		if(alcohol.isEmpty()) {
			this.alc.save(bottle.getAlcohol());
			alcohol = this.alc.findByName(bottle.getAlcohol().getName());
		}
		bottle.setAlcohol(alcohol.get());
		return this.repo.save(bottle);
	}

	@Override
	public void deleteById(Integer id) {
		this.repo.deleteById(id);
	}	

}
