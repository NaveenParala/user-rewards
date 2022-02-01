package com.myapp.user.reward.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.user.reward.model.User;
import com.myapp.user.reward.repository.UserRepository;

@Service
public class UserService {
	private static final Logger serviceLogger= LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User createNewUser(User user) {
		User savedUser=null;
		
		if(user!=null) {
			 savedUser=userRepository.save(user);
		}
		else {
			serviceLogger.error("user object is empty "+user);
		}
	return savedUser;
		
	}


	public List<User> getAllUserFromDb() {
		List<User> list=null;
		
		list=userRepository.findAll();
		
		if(!list.isEmpty()) {
			return list;
		}else {
			serviceLogger.error("list is empty "+list);
		}
		return null;
	}


	public User getOneUserFromDb(Long userId) {
		User user=null; 
		user=userRepository.findById(userId).get();
		if(user!=null) {
			return user;
		}else {
			serviceLogger.error("user is not found with this id "+userId);
		}
		return null;
	}
	
	

}
