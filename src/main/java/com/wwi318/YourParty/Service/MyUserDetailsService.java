package com.wwi318.YourParty.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Entity.MyUserDetails;
import com.wwi318.YourParty.Entity.Role;
import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		Optional<User> user = userRepository.findByUsername(userName);
//		user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
//		return user.map(MyUserDetails::new).get();
//	}
//
//	public User save(User user) {
//		if (user.getid() != null && userRepository.existsById(user.getId())) {
//			throw new EntityExistsException("There is an entity with such an ID");
//		}
//		return userRepository.save(user);
//	}


}
