package com.bertrand.mixo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level=AccessLevel.PRIVATE)
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Bottle")
public class Bottle {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idBottle")
	int id;
	
	@Column(name="Number")
	int number;
	
	@Column(name="Volume")
	int volume;
	
	@Column(name="Price")
	int priceInCentsFor1Cl;
	
	@Column(name="Brand")
	String brand;
	
	@ManyToOne
	@JoinColumn(name = "AlcoholId")
	Alcohol alcohol;

}
