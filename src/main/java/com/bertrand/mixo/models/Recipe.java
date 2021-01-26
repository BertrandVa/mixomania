package com.bertrand.mixo.models;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@AllArgsConstructor
public class Recipe {
	
	int id;
	int priceInCentsFor1Cl;
	Map<Alcohol, Integer> ingredients;

}
