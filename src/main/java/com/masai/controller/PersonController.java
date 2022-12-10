package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.UserException;
import com.masai.model.Person;
import com.masai.service.PersonService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class PersonController {
	
	@Autowired
	public PersonService pservice;
	
	@PostMapping("/person")
	public ResponseEntity<Person> Saveperon(@RequestBody Person person) throws UserException{
		
		Person savedperson=pservice.Saveperson(person);
		
		return new ResponseEntity<>(savedperson,HttpStatus.OK);
		
	}
	
	@GetMapping("/person")
	public ResponseEntity<List<Person>> getAllPerson() throws UserException{
		
		List<Person> pdao=pservice.getAllPerson();
		return new ResponseEntity<List<Person>>(pdao,HttpStatus.OK);
		
	}

}
