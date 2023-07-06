package com.springboot.restapi.socialmedia.info;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class UserDetails {

	@Id
	@GeneratedValue
	private int id;
	@Size(min = 2)
	private String name;
	@Past
	private LocalDate birthDate;

}
