package com.wwi318.YourParty.Service;

public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
}
