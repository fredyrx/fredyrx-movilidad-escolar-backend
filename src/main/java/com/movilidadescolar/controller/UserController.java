package com.movilidadescolar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.User;
import com.movilidadescolar.repo.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository repository;
	
	@RequestMapping("/save")
	public String process(){		
		repository.save(new User("pepito3@mailinator.com","pass","pepito","dos cañones"));
		return "Done";
	}
	
	@RequestMapping("/findall")
	public List<User> findAll(){
		List<User> result;
		result = repository.findAll();
		System.out.println(result.size());
		return result;
	}
	
	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		/*result = repository.findOne(id).toString();
		*/return result;
	}
}
