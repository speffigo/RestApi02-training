package com.springboot.restapi.socialmedia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.socialmedia.info.UserDetails;
import com.springboot.restapi.socialmedia.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {

	private UserRepository repository;

	public UserJpaController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/jpa/users")
	public List<UserDetails> getAllDetails() {
		return repository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public Optional<UserDetails> getById(@PathVariable int id) {
		return repository.findById(id);
	}

	@PostMapping("/jpa/users/post")
	public UserDetails createDetails(@Valid @RequestBody UserDetails user) {
		return repository.save(user);
	}

	@DeleteMapping("/jpa/users/delete/{id}")
	public void deleteDetails(@PathVariable int id) {
		repository.deleteById(id);
	}
}
