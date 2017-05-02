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
import com.movilidadescolar.model.School;
import com.movilidadescolar.repo.DriverRepository;
import com.movilidadescolar.repo.SchoolRepository;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

	@Autowired
	SchoolRepository repository;
	
	@Autowired
	DriverRepository driverRepo;
	
	@RequestMapping(method = RequestMethod.GET )
	public Response getSchools(){
		List<School> schools = repository.findAll();
		Response res = new Response(schools,"ok");
		return res;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public School insertSchool(@RequestBody School school){
		return repository.save(school);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public School getSchoolById(@PathVariable Long id){
		return repository.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public boolean deleteSchoolById(@PathVariable Long id){
		repository.delete(id);
		return true;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/{school_id}/drivers")
	public Response getClientsBySchools(@PathVariable Long school_id){
		List<Driver> drivers = driverRepo.findBySchoolDriversSchoolId(school_id);
		return new Response(drivers,"ok");
	}
	
}
