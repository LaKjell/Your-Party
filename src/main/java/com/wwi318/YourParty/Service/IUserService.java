package com.wwi318.YourParty.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import com.wwi318.YourParty.Entity.User;
import com.wwi318.YourParty.Entity.UserDto;
import com.wwi318.YourParty.Exception.EmailExistsException;
import com.wwi318.YourParty.Exception.UserAlreadyExistException;

public interface IUserService {

    User registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException, EmailExistsException;

    User getUser(String verificationToken);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    void createVerificationTokenForUser(User user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(User user, String token);

    User findUserByEmail(String email);

    PasswordResetToken getPasswordResetToken(String token);

    User getUserByPasswordResetToken(String token);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(User user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(User user) throws UnsupportedEncodingException;

    List<String> getUsersFromSessionRegistry();

}
