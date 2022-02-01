package com.myapp.user.reward.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.user.reward.model.Reward;
import com.myapp.user.reward.service.RewardsService;

@RestController
@RequestMapping("/reward")
public class RewardsController {
	private static final Logger logger=LoggerFactory.getLogger(RewardsController.class);
	
	@Autowired
	private RewardsService rewardsService;
	
	@PostMapping("/saveReward")
	public Reward createUserReward(@RequestBody Reward reward) {
		Reward saveReward =null;
		if(reward!=null) {
			
			saveReward=rewardsService.createRewardForUser(reward);
		}else {
			logger.error("reward object is empty "+reward);
		}		
		return saveReward;	
	}
	
	

}
