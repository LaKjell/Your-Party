package com.wwi318.YourParty.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wwi318.YourParty.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	Optional<User> findByUser(String username);
	User findByUsername(String username);
	
	boolean existsById(User user);

}
