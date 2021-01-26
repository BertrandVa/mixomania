package com.bertrand.mixo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bertrand.mixo.models.Alcohol;

@RestController
public class AlcoholController {
	
	@PostMapping(path = "/createAlcoholType")
	public int createType(@RequestParam(value= "name") String name) {
		Alcohol alcohol = new Alcohol(null, name);
		return HttpStatus.OK.value();
	}

}
