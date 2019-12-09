package com.wwi318.YourParty.Service;

import java.util.Optional;

import com.wwi318.YourParty.Entity.User;

public interface UserService {

	void save(User user);
	
	User findByUsername(String username);

//	Optional<User> findByUser(String name);
}
