package com.wwi318.YourParty.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.wwi318.YourParty.Entity.User;

public interface UserService {
	
	void save(User user);

	User findByUsername(String username);

}
