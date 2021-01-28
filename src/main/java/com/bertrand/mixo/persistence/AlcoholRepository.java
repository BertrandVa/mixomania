package com.bertrand.mixo.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bertrand.mixo.models.Alcohol;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Integer> {

	Optional<Alcohol> findByName(String name);
	
	Optional<Alcohol> findById(Integer id);
	
}
