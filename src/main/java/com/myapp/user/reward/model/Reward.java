package com.myapp.user.reward.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rewardId;
	private String rewardName;
	private double rewardAmount;
	private Long userId;

}
