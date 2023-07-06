package com.springboot.restapi.socialmedia.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import com.springboot.restapi.socialmedia.info.UserDetails;

@Service
public class UserDaoServices {

	private static List<UserDetails> users = new ArrayList<>();
	private static int usercount = 0;

	static {
		users.add(new UserDetails(++usercount, "Abhishek", LocalDate.now().minusYears(20)));
		users.add(new UserDetails(++usercount, "Saurabh", LocalDate.now().minusYears(15)));
		users.add(new UserDetails(++usercount, "Aman", LocalDate.now().minusYears(12)));

	}

	public List<UserDetails> findDetails() {
		return users;
	}

	public UserDetails fingDetailsById(int id) {
		Predicate<? super UserDetails> predicate = user -> user.getId() == (id);
		return users.stream().filter(predicate).findFirst().get();
	}

	public static List<UserDetails> addDetails(UserDetails user) {
		user.setId(++usercount);
		users.add(user);
		return users;
	}

	public List<UserDetails> deleteById(int id) {
		Predicate<? super UserDetails> predicate = user -> user.getId() == (id);
		users.removeIf(predicate);
		return users;
	}

}
