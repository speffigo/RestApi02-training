package com.springboot.restapi.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.socialmedia.versoning.Name;
import com.springboot.restapi.socialmedia.versoning.PersonV1;
import com.springboot.restapi.socialmedia.versoning.PersonV2;

@RestController
public class VersoningPerson {

	String name1 = "Alice Adam";

	@GetMapping("/v1/person")
	public PersonV1 getfirstVersonOfPerson() {
		return new PersonV1(name1);
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersonOfPerson() {
		return new PersonV2(new Name("Alice", "Adam"));
	}

	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getfirstVersonOfPersonRequestParm() {
		return new PersonV1(name1);
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getSecondVersonOfPersonRequestParm() {
		return new PersonV2(new Name("Alice", "Adam"));
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getDataForV1RequestParmHeader() {
		return new PersonV1(name1);
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getDataForV2RequestParmHeader() {
		return new PersonV2(new Name("Alice", "Adam"));
	}

}
