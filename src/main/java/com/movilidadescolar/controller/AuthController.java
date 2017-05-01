package com.movilidadescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Client;
import com.movilidadescolar.model.Driver;
import com.movilidadescolar.model.Login;
import com.movilidadescolar.model.Response;
import com.movilidadescolar.repo.ClientRepository;
import com.movilidadescolar.repo.DriverRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	DriverRepository driverRepo;
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/client")
	public Response clientAuthenticate(@RequestBody Login login){
		System.out.println("*****************");
		System.out.println(login.getUsername()+login.getPassword());
		Client user = clientRepo.findByEmailAndPassword(login.getUsername(), login.getPassword());
		Response response = new Response(user, "User sign in successfully");
		if (response.getData() == null) {
			response.setError("Not Found");
			response.setMessage("Email y/o password incorrecto(s)");
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/driver")
	public Response driverAuthenticate(@RequestBody Login login){
		Driver user = driverRepo.findByEmailAndPassword(login.getUsername(), login.getPassword());
		Response response = new Response(user, "User sign in successfully");
		if (response.getData() == null) {
			response.setError("Not Found");
			response.setMessage("Email y/o password incorrecto(s)");
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup/client")
	public Response clientSignUp(@RequestBody Client client)
	{
		Client userCreated = clientRepo.save(client);
		Response response = new Response(userCreated, "User signup successfully");
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup/driver")
	public Response driverSignUp(@RequestBody Driver driver)
	{
		Driver userCreated = driverRepo.save(driver);
		Response response = new Response(userCreated, "User signup successfully");
		return response;
	}
}
