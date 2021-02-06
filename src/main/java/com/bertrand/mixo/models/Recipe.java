package com.bertrand.mixo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
@Table(name="Recipe")
public class Recipe {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idRecipe")
	int id;
	
	@Transient
	int priceInCentsFor1Cl;
	
	@Column(name="Name")
	String name;
	
    @OneToMany( targetEntity=Ingredient.class, cascade = CascadeType.ALL)
    @JoinColumn
    List<Ingredient> ingredients;

}
