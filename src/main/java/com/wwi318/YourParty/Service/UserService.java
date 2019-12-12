package com.wwi318.YourParty.Service;

import com.wwi318.YourParty.Entity.User;

public interface UserService {

	void save(User user);

	User findById(int id);

	User findByUsername(String username);

}
