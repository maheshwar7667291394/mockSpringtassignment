package com.masai.service;

import java.util.List;

import com.masai.exceptions.UserException;
import com.masai.model.Person;

public interface PersonService {
	public Person Saveperson(Person person)throws UserException;
	public List<Person> getAllPerson()throws UserException;
	

}
