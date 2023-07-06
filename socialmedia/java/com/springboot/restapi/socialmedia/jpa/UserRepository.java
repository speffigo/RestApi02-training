package com.springboot.restapi.socialmedia.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.restapi.socialmedia.info.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
