package com.wwi318.YourParty.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FragmentsController {
	
	
	 
	    @GetMapping("/Head_Nav_Footer")
	    public String getHome() {
	        return "fragments/Head_Nav_Footer.html";
	    }
}
