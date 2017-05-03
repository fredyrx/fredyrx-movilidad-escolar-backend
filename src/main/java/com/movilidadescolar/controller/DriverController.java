package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Driver;
import com.movilidadescolar.model.Response;
import com.movilidadescolar.repo.DependentRepository;
import com.movilidadescolar.repo.DriverRepository;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

	@Autowired
	DriverRepository repository;
	
	@Autowired
	DependentRepository dependentRepo;

	
	@RequestMapping(method = RequestMethod.GET)
	public List<Driver> getClients(){
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Driver getClientById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	// Necesita registrar user como campo de client
	@RequestMapping(method = RequestMethod.POST)
	public Response setClient(@RequestBody Driver client){
		return new Response(repository.save(client),"signUp OK");
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{school_id}/schools")
	public List<Driver> getClientsBySchools(@PathVariable Long school_id){
		return repository.findBySchoolDriversSchoolId(school_id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{driver_id}/dependant")
	public Response listDependantForDriver(@PathVariable int driver_id){
		return new Response(dependentRepo.findByContranctsDriverId(driver_id),"ok");
	}

}
