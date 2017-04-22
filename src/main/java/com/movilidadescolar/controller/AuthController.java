package com.movilidadescolar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movilidadescolar.model.Login;
import com.movilidadescolar.model.User;
import com.movilidadescolar.repo.UserRepository;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	UserRepository userRepo;
	
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
		public Response(Object data) {
			this.data = data;
			this.error = "";
			this.status = 200;
			this.message = "";
		}
		
		protected Response(){
			
		}
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/auth")
	public Response authenticate(@RequestBody Login login){
		User user = userRepo.findByEmailAndPasswordHash(login.getUsername(), login.getPassword());
		Response response = new Response(user);
		if (response.getData() == null) {
			response.setError("Not Found");
			response.setMessage("Email y/o password incorrecto(s)");
		}
		return response;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/signup")
	public Response signUp(@RequestBody User user)
	{
		User userCreated = userRepo.save(user);
		Response response = new Response(userCreated);
		return response;
	}
}
