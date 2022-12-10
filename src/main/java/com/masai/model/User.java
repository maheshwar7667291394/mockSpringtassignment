package com.masai.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity

public class User {

	@Id
	private String email;
    @Pattern(regexp = "^[A-Z][a-z]*",message="first name not contain number and special character")
	private String firstname;
    @Pattern(regexp = "^[A-Z][a-z]*",message="last name not contain number and special character")
	private String lastname;
    @Size(min=10,message="length should be beatween 6 to 12")
	private String mobileNo;
	
	
	@Size(min=6,max=12,message="length should be beatween 6 to 12")
	private String password;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<Person> person=new ArrayList<>();
	
	

}
