package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.User;
import com.movilidadescolar.repo.UserRepository;

@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/save")
	public String process(){		
		repository.save(new User("pepito3@mailinator.com","pass","pepito","dos cañones"));
		return "Done";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		List<User> result;
		result = repository.findAll();
		System.out.println(result.size());
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public User findById(@PathVariable Integer id){
		return repository.findById(id);
	}
}
