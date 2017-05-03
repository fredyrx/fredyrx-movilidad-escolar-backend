package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Dependent;
import com.movilidadescolar.repo.DependentRepository;

@RestController
@RequestMapping("/api/dependant")
public class DependentController{

	@Autowired
	DependentRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Dependent> getAll(){
		return repository.findAll();
	}
}
