package com.myapp.user.reward.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.user.reward.model.User;
import com.myapp.user.reward.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger controllerLogger= LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/saveUser")
	public User createNewUser(@RequestBody User user) {
		User saveUser=null;
		if(user!= null) {
			saveUser=userService.createNewUser(user);
		}else {
			controllerLogger.error("user object is empty "+user);
		}
		return saveUser;
		
	}
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		List<User> list=null;
		list=userService.getAllUserFromDb();
		if(!list.isEmpty()) {
			return list;
		}else {
			controllerLogger.error("list is empty "+list);
		}
		return null;
		
	}
	@GetMapping("/getById/{id}")
	public User getUsersById(@PathVariable Long id){
		User userbyId=null;
		userbyId=userService.getOneUserFromDb(id);
		if(userbyId!=null) {
			return userbyId;
		}else {
			controllerLogger.error("user is not found with this id "+id);
		}
		return null;
		
	}

}
