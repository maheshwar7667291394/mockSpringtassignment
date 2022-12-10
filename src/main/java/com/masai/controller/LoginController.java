package com.masai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService uLogin;
	
	@PostMapping("/masaimail/login")
	public ResponseEntity<String> logInUser(@RequestBody LoginDTO dto) throws LoginException {
		
		String result = uLogin.logIntoAccount(dto);
		

		
		return new ResponseEntity<String>(result,HttpStatus.OK );
		
		
	}
	
	@PostMapping("/masaimail/logout")
	public String logoutUser(@RequestParam(required = false) String key) throws LoginException {
		return uLogin.logOutFromAccount(key);
		
	}
	
	
	
}
