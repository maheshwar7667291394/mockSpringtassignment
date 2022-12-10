package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;
import com.masai.dao.persondao;
import com.masai.exceptions.UserException;
import com.masai.model.Person;
import com.masai.model.User;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	public UserDao udao;
	
	@Autowired
	public persondao pdao; 

	@Override
	public Person Saveperson(Person person) throws UserException {
		
		User user=person.getUser();
		user.getPerson().add(person);
		
		udao.save(user);
		return person;
		
		
		
	}

	@Override
	public List<Person> getAllPerson() throws UserException {
		
		List<Person> persons=pdao.findAll();
		if(persons.size()==0) {
			throw new UserException("person not fpound");
		}
		return persons;
	}

}
