package com.myapp.user.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.user.reward.model.Reward;

public interface RewardsRepository extends JpaRepository<Reward, Long> {

}
