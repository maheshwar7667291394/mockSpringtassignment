package com.masai.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;
import com.masai.dao.SessionDao;
import com.masai.exceptions.UserException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Person;
import com.masai.model.User;

@Service

public class UserDaoServiceImpl implements UserService {

	@Autowired
	private UserDao cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	@Override
	public User createCustomer(User user)throws UserException {
		
		

		User existingCustomer= cDao.findByemail(user.getEmail());
		
		
		
		if(existingCustomer != null) {

		
//		  throw new UserException("Customer Already Registered with email address");
			
			List<Person> persoExist=existingCustomer.getPerson();
			   for(Person person:persoExist) {
				   person.setUser(user);
			   }
		  
		  
		}
			
		
		
		
			return cDao.save(user);
			
			
		}

	@Override
	public User updateCustomer(User user, String key) throws UserException{
	
		CurrentUserSession loggedInUser= sDao.findByUuid(key);
	
		if(loggedInUser == null) {
			throw new UserException("Please provide a valid key to update a customer");
		}
		
		

	
		
		if(user.getEmail() == loggedInUser.getEmail()) {
			
			return cDao.save(user);
		}
		else
			throw new UserException("Invalid Customer Details, please login first");
	
	}
		
		
		
	}


