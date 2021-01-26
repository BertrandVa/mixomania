package com.bertrand.mixo.models;

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
public class Bottle {
	
	int id;
	int number;
	int volume;
	int priceInCentsFor1Cl;
	String brand;
	Alcohol alcohol;

}
