package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.dao.UserDao;
import com.masai.dao.SessionDao;
import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.User;
import com.masai.model.LoginDTO;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao cDao;
	
	@Autowired
	private SessionDao sDao;
	
	
	
	@Override
	public String logIntoAccount(LoginDTO dto)throws LoginException{
		
		

		User existingCustomer= cDao.findByemail(dto.getEmail());
		
		if(existingCustomer == null) {
			
			throw new LoginException("Please Enter a valid email address");
			
			 
		}
		
		
		
		

		Optional<CurrentUserSession> validCustomerSessionOpt =  sDao.findById(existingCustomer.getEmail());
		
		
		
		
		
		if(validCustomerSessionOpt.isPresent()) {
			
			throw new LoginException("User already Logged In with this number");
			
		}
		
		if(existingCustomer.getPassword().equals(dto.getPassword())) {
			
			String key= RandomString.make(6);
			
			
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existingCustomer.getEmail(),key,LocalDateTime.now());
			
			sDao.save(currentUserSession);

			return currentUserSession.toString();
		}
		else
			throw new LoginException("Please Enter a valid password");
		
		
	}


	@Override
	public String logOutFromAccount(String key)throws LoginException {
		
		CurrentUserSession validCustomerSession = sDao.findByUuid(key);
		
		
		if(validCustomerSession == null) {
			throw new LoginException("User Not Logged In with this number");
			
		}
		
		
		sDao.delete(validCustomerSession);
		
		
		return "Logged Out !";
		
		
	}

}
