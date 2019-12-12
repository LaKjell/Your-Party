package com.wwi318.YourParty.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.wwi318.YourParty.Entity.Booking;
import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Service.LocationService;
import com.wwi318.YourParty.Service.UserService;

@Controller
public class BookingController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LocationService locationService;

	@PostMapping("/Locations/booking")
	public String registration(@ModelAttribute("userForm") Booking userForm) {

		User user = userService.findById(userForm.getUserId());
		Optional<Location> location = locationService.findById(userForm.getLocationId());

		return "";
	}
}
