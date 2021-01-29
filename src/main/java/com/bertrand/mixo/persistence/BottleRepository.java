package com.bertrand.mixo.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bertrand.mixo.models.Alcohol;
import com.bertrand.mixo.models.Bottle;

@Repository
public interface BottleRepository extends JpaRepository<Bottle, Integer> {

	Optional<Bottle> findById(Integer id);
	List<Bottle> findByAlcohol(Alcohol alcohol);
	Optional<Bottle> findByBrand(String brand);
	
}
