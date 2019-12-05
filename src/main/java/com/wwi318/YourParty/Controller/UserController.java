package com.wwi318.YourParty.Controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Service.MyUserDetailsService;
import com.wwi318.YourParty.Service.SecurityService;
import com.wwi318.YourParty.Service.UserService;
import com.wwi318.YourParty.Validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@PostMapping("/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "SignIn";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "index";
	}

	// Funktionen anlegen, �ndern, l�schen
	@RequestMapping(method = RequestMethod.POST, value = "/user",
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public @ResponseBody ResponseEntity<User> createUser(User user) {
		try {
			userService.save(user);
			return new ResponseEntity<User>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<User>(HttpStatus.CONFLICT);
		}
	}

//	@Autowired
//	MyUserDetailsService userDetails;

//	@RequestMapping(method = RequestMethod.POST, value = "user/create")
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		try {
//			User results = userDetails.save(user);
//			return null;
////			return (ResponseEntity<User>) ResponseEntity.created(new URI("/api/user/" + results.getUserName().body(results)));
//		} catch (Exception e) {
//			return new ResponseEntity<User>(HttpStatus.CONFLICT);
//		}
//	}

}