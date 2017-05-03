package com.movilidadescolar.controller;

import java.lang.invoke.MethodType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Contract;
import com.movilidadescolar.repo.ContractRepository;

@RestController
@RequestMapping("/api/contracts")
public class ContractController {

	@Autowired
	ContractRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Contract findById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Contract> getAll(){
		return repository.findAll();
	}
}
