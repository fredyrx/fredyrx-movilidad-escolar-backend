package com.movilidadescolar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Client;
import com.movilidadescolar.model.Dependent;
import com.movilidadescolar.model.Response;
import com.movilidadescolar.repo.ClientRepository;
import com.movilidadescolar.repo.DependentRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

	@Autowired
	ClientRepository repository;
	
	@Autowired
	DependentRepository dependentRepo;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Client> getClients(){
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Client getClientById(@PathVariable Integer id){
		return repository.findById(id);
	}
	
	// Necesita registrar user como campo de client
	@RequestMapping(method = RequestMethod.POST)
	public Response setClient(@RequestBody Client client){
		Client clientRegistered = repository.save(client);
		Response res = new Response(clientRegistered,"Client Sign Up ok");
		return res;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{client_id}/dependant")
	public List<Dependent> getDependantFromClient(@PathVariable Integer client_id){
		List<Dependent> dependant = new ArrayList<>();
		Client user = repository.findById(client_id);
		if (user != null){
			dependant = user.getDependant();
		}
		return dependant;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/{client_id}/dependant")
	public Response setDependentForClient(@PathVariable Integer client_id, @RequestBody Dependent dependent){
		Client client = repository.findById(client_id);
		dependent.setClient(client);
		Dependent dependentCreated = dependentRepo.save(dependent);
		return new Response(dependentCreated,"Se guard� correctamente.");
	}
	
		
	
}
