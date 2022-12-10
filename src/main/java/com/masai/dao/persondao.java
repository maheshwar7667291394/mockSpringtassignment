package com.masai.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Person;

@Repository
public interface persondao extends JpaRepository<Person, Integer>{

}
