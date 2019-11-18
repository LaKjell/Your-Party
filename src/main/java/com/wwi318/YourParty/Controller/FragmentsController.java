package com.wwi318.YourParty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
	
	
	 
	    @GetMapping("/Navigation")
	    public String getHome() {
	        return "fragments/Navigation.html";
	    }
}
