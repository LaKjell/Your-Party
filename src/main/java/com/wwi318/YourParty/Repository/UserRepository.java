package com.wwi318.YourParty.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wwi318.YourParty.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Override
    void delete(User user);

}
