package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Client;
import com.movilidadescolar.repo.ClientRepository;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Client> getClients(){
		return repository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Client getClientById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	// Necesita registrar user como campo de client
	@RequestMapping(method = RequestMethod.POST)
	public Client setClient(@RequestBody Client client){
		return repository.save(client);
	}
	
		
	
}
