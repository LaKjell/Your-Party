package com.wwi318.YourParty.Validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Service.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> aClass) {
		return User.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		User user = (User) o;

		//Username prüfen
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
			errors.rejectValue("username", "Size.userForm.username");
		}
		if (Pattern.matches("[0-9a-zA-Z]", user.getUsername())) {
			errors.rejectValue("username", "Character.userForm.username");
		}
		if (userService.findByUsername(user.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		//Passwort prüfen
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "NotEmpty");
		if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
			errors.rejectValue("password", "Size.userForm.password");
		}
		if (Pattern.matches("[0-9a-zA-Z]", user.getPassword())) {
			errors.rejectValue("password", "Character.userForm.password");
		}
		if (!user.getPasswordConfirm().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
		}
		
		//Name prüfen
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "NotEmpty");
		if (Pattern.matches("[a-zA-Z]", user.getFirstname())) {
			errors.rejectValue("firstname", "Character.userForm.firstname");
		}
		if (Pattern.matches("[a-zA-Z]", user.getLastname())) {
			errors.rejectValue("lastname", "Character.userForm.lastname");
		}
		
		//Geschlecht und Typ
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "NotEmpty");
		
		//Adresse prüfen
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postcode", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "housenumber", "NotEmpty");
		if (Pattern.matches("[a-zA-Z]", user.getCountry())) {
			errors.rejectValue("country", "Character.userForm.country");
		}
		if (Pattern.matches("[a-zA-Z]", user.getCity())) {
			errors.rejectValue("city", "Character.userForm.city");
		}
		if (Pattern.matches("[0-9]", user.getPostcode())) {
			errors.rejectValue("postcode", "Character.userForm.postcode");
		}
		if (Pattern.matches("[a-zA-Z]", user.getStreet())) {
			errors.rejectValue("street", "Character.userForm.Street");
		}
		if (Pattern.matches("[0-9]", user.getHousenumber())) {
			errors.rejectValue("housenumber", "Character.userForm.housenumber");
		}
		
		//E-Mail und Telefon prüfen
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phonenumber", "NotEmpty");
//		if (Pattern.matches("[\\w|-]+@\\w[\\w|-]*\\.[a-z]{2,3}", user.getEmail())) {
//			errors.rejectValue("email", "Character.userForm.email");
//		}
		
	}
}
