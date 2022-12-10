package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;
@Repository
public interface UserDao extends JpaRepository<User, String>{

	public User findByMobileNo(String mobileNo);
	public User findByemail(String email);

}
