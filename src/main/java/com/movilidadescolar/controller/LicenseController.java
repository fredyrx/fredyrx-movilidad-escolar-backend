package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.License;
import com.movilidadescolar.repo.LicenseRepository;

@RestController
@RequestMapping("/licenses")
public class LicenseController {
	
	@Autowired
	LicenseRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<License> getLicenses(){
		return repository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public License insertLicense(@RequestBody License license){
		return repository.save(license);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public License getLicenseById(@PathVariable String id){
		return repository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public boolean deleteById(@PathVariable String id){
		License license = repository.findById(id);
		repository.delete(license);
		return true;
	}
}
