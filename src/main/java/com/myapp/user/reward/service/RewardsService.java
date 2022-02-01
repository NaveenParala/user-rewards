package com.myapp.user.reward.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.user.reward.model.Reward;
import com.myapp.user.reward.model.User;
import com.myapp.user.reward.repository.RewardsRepository;
import com.myapp.user.reward.repository.UserRepository;

@Service
public class RewardsService {
	
	private static final Logger logger=LoggerFactory.getLogger(RewardsService.class);
	
	@Autowired
	private RewardsRepository rewardsRepository;

	@Autowired
	private UserRepository userRepository;
	
	
	public Reward createRewardForUser(Reward reward) {
		
		Reward savedReward=null;
		User user=userRepository.findById(reward.getUserId()).get();
		if(user!=null) {
			savedReward=rewardsRepository.save(reward);
			return savedReward;	
		}
		else {
			logger.error("User not exist with this id to create a reward "+reward.getUserId());
		}
		return savedReward;
	}

}
