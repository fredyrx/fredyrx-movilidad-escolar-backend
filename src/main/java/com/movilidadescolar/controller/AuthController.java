package com.movilidadescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Client;
import com.movilidadescolar.model.Driver;
import com.movilidadescolar.model.Login;
import com.movilidadescolar.repo.ClientRepository;
import com.movilidadescolar.repo.DriverRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	DriverRepository driverRepo;
	
	public class Response{
		
		private int status;
		private Object data;
		private String error;
		private String message;
		
		public String getError() {
			return error;
		}
		public void setError(String error) {
			this.error = error;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Response(Object data, String message) {
			this.data = data;
			this.error = "";
			this.status = 200;
			this.message = message;
		}
		
		protected Response(){
			
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/login/client")
	public Response clientAuthenticate(@RequestBody Login login){
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
