package com.wwi318.YourParty.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import com.wwi318.YourParty.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsername(String username);

	boolean existsById(User user);

}
