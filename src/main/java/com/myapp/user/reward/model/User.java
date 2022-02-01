package com.myapp.user.reward.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String userFirstName;
	private String userLastName;
	private int  userAge;
	private String userEmail;
	private String userPhoneNo;
	
}
