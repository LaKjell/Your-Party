package com.wwi318.YourParty.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Service.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET, value = "/username/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User currentUser(@PathVariable String username) {
         if (userService.findByUsername(username).isActive())
 			return userService.findByUsername(username);
 		else
 			return null;
    }
}
