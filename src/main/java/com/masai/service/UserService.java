package com.masai.service;

import com.masai.exceptions.UserException;
import com.masai.model.User;

public interface UserService {
	
	
	public User createCustomer(User customer)throws UserException;
	
	public User updateCustomer(User customer,String key)throws UserException;
	
	
	
	
}
