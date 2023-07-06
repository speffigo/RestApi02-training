package com.springboot.restapi.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.socialmedia.info.UserDetails;
import com.springboot.restapi.socialmedia.services.UserDaoServices;

import jakarta.validation.Valid;

@RestController
public class UserDetailsController {

	private UserDaoServices service;

	public UserDetailsController(UserDaoServices service) {
		super();
		this.service = service;
	}

	@GetMapping("/users")
	public List<UserDetails> getAllDetails() {
		return service.findDetails();
	}

	@GetMapping("/users/{id}")
	public UserDetails getById(@PathVariable int id) {
		return service.fingDetailsById(id);
	}

	@PostMapping("users/post")
	public List<UserDetails> createDetails(@Valid @RequestBody UserDetails user) {
		return service.addDetails(user);
	}

	@DeleteMapping("users/delete/{id}")
	public List<UserDetails> deleteDetails(@PathVariable int id) {
		return service.deleteById(id);
	}
}
