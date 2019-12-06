package com.wwi318.YourParty.Validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wwi318.YourParty.Entity.Location;
import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Service.LocationService;

@Component
public class LocationValidator implements Validator{

	@Autowired
	LocationService locationService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Location.class.equals(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Location location = (Location) target;
		//Überprüfen ob Felder gefüllt
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "housenumber", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");
		

		//Name und Besitzer der Location prüfen
		if (Pattern.matches("[a-zA-Z]", location.getName())) {
			errors.rejectValue("username", "Character.userForm.name");
		}
		if (locationService.findByName(location.getName()) != null) {
			errors.rejectValue("name", "Duplicate.userForm.name");
		}
		if (Pattern.matches("[a-zA-Z]", location.getOwner())) {
			errors.rejectValue("owner", "Character.userForm.owner");
		}
		
		//Adresse prüfen
		if (Pattern.matches("[a-zA-Z]", location.getCity())) {
			errors.rejectValue("city", "Character.userForm.city");
		}
		if (Pattern.matches("[0-9]", location.getPostcode())) {
			errors.rejectValue("postcode", "Character.userForm.postcode");
		}
		if (Pattern.matches("[a-zA-Z]", location.getStreet())) {
			errors.rejectValue("street", "Character.userForm.street");
		}
		if (Pattern.matches("[0-9]", location.getHousenumber())) {
			errors.rejectValue("housenumber", "Character.userForm.housenumber");
		}
		if (Pattern.matches("[a-zA-Z]", location.getCountry())) {
			errors.rejectValue("country", "Character.userForm.country");
		}
		
		//sonst. Daten prüfen
		if (Pattern.matches("[a-zA-Z]", location.getDescription())) {
			errors.rejectValue("description", "Character.userForm.description");
		}
		
	}
	
}
