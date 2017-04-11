package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.State;
import com.movilidadescolar.repo.StateRepository;

@RestController
@RequestMapping("/states")
public class StateController {

	@Autowired
	StateRepository repository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/setup")
	public String insertBasicsStates(){
		repository.save(new State("PH","Pick up from home",1, true));
		return "Done";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public State insert(@RequestBody State inputState){
		State stateSaved = repository.save(inputState);
		return stateSaved;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<State> getAll(){
		List<State> states = repository.findAll();
		return states;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public State getById(@PathVariable String id){
		State state = repository.findById(id);
		return state;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/order/{orderNumber}")
	public State getById(@PathVariable Integer orderNumber){
		State state = repository.findByOrderNumber(orderNumber);
		return state;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public boolean deleteById(@PathVariable String id){
		State state = repository.findById(id);
		repository.delete(state);
		return true;
	}
	
}
