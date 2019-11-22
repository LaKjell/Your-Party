package com.wwi318.YourParty.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Entity.UserDto;
import com.wwi318.YourParty.Exception.EmailExistsException;
import com.wwi318.YourParty.Repository.UserRepository;
import com.wwi318.YourParty.Service.IUserService;
import com.wwi318.YourParty.Service.PasswordResetToken;
import com.wwi318.YourParty.Service.UserService;
import com.wwi318.YourParty.Service.VerificationToken;

public class RegistrationController {

	@Autowired
    private IUserService userService;
	
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String showRegistrationForm(WebRequest request, Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "registration";
	}

	@Service
	public class UserService implements IUserService {
		@Autowired
		private UserRepository repository;

		@Transactional
	    @Override
	    public User registerNewUserAccount(UserDto accountDto) 
	      throws EmailExistsException {
	         
	        if (emailExist(accountDto.getEmail())) {  
	            throw new EmailExistsException(
	              "There is an account with that email adress: "
	              +  accountDto.getEmail());
	        }
			return null;
	    }

		private boolean emailExist(String email) {
			User user = repository.findByEmail(email);
			if (user != null) {
				return true;
			}
			return false;
		}
		
		@RequestMapping(value = "/user/register", method = RequestMethod.POST)
		public ModelAndView registerUserAccount(
		  @ModelAttribute("user") @Valid UserDto accountDto, 
		  BindingResult result, 
		  WebRequest request, 
		  Errors errors) {
		     
		    User registered = new User();
		    if (!result.hasErrors()) {
		        registered = createUserAccount(accountDto, result);
		    }
		    if (registered == null) {
		        result.rejectValue("email", "message.regError");
		    }
		    if (result.hasErrors()) {
		        return new ModelAndView("registration", "user", accountDto);
		    } 
		    else {
		        return new ModelAndView("successRegister", "user", accountDto);
		    }
		}
		private User createUserAccount(UserDto accountDto, BindingResult result) {
		    User registered = null;
		    try {
		        registered = userService.registerNewUserAccount(accountDto);
		    } catch (EmailExistsException e) {
		        return null;
		    }
		    return registered;
		}

		@Override
		public User getUser(String verificationToken) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void saveRegisteredUser(User user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteUser(User user) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void createVerificationTokenForUser(User user, String token) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public VerificationToken getVerificationToken(String VerificationToken) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public VerificationToken generateNewVerificationToken(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void createPasswordResetTokenForUser(User user, String token) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public User findUserByEmail(String email) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public PasswordResetToken getPasswordResetToken(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public User getUserByPasswordResetToken(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Optional<User> getUserByID(long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void changeUserPassword(User user, String password) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean checkIfValidOldPassword(User user, String password) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String validateVerificationToken(String token) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String generateQRUrl(User user) throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<String> getUsersFromSessionRegistry() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
