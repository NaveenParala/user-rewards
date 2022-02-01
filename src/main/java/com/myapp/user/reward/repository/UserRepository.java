package com.myapp.user.reward.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.user.reward.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
