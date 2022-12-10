package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.model.User;
import com.masai.service.UserService;

@RestController
@Valid
public class UserController {

	@Autowired
	private UserService cService;
	
	
	@PostMapping("/masaimail/register")
	public ResponseEntity<User> saveUser(@RequestBody @Valid User customer) throws UserException {
		
		User savedCustomer= cService.createCustomer(customer);
		
		
		return new ResponseEntity<User>(savedCustomer,HttpStatus.CREATED);
	}
	
	@PutMapping("/masaimail/users")
	public  ResponseEntity<User> updateUser(@RequestBody User customer,@RequestParam(required = false) String key ) throws UserException {
		
		
		User updatedCustomer= cService.updateCustomer(customer, key);
				
		return new ResponseEntity<User>(updatedCustomer,HttpStatus.OK);
		
	}
	


	
	
	
	
	
	
	
	
	
}
