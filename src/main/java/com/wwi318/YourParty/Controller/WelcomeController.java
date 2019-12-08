package com.wwi318.YourParty.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	@Value("${spring.application.name}")
    String appName;
 
    @GetMapping("/")
    public String homePage(Model modelHome) {
        modelHome.addAttribute("appName", appName);
        return "index";
    }
    
    @GetMapping("/Locations")
    public String LocationsPage(Model modelLocations) {
        modelLocations.addAttribute("appName", appName);
        return "Locations";
    }
    
    @GetMapping("/Profil")
    public String ProfilPage(Model modelProfil) {
        modelProfil.addAttribute("appName", appName);
        return "Profil";
    }
    
    @GetMapping("/Login")
    public String SignPage(Model modelSign) {
        modelSign.addAttribute("appName", appName);
        return "SignIn";
    }
    
//    @GetMapping("/registration")
//    public String RegisterPage(Model modelRegister) {
//        modelRegister.addAttribute("appName", appName);
//        return "Register";
//    }
    
    @GetMapping("/Impressum")
    public String ImpressumPage(Model modelRegister) {
        modelRegister.addAttribute("appName", appName);
        return "Impressum";
    }
    
    @GetMapping("/Locations/create")
    public String CreatePage(Model modelRegister) {
        modelRegister.addAttribute("appName", appName);
        return "create";
    }
    
    @GetMapping("/Crew")
    public String CrewPage(Model modelCrew) {
        modelCrew.addAttribute("appName", appName);
        return "Crew";
    }
    
    @GetMapping("/Help")
    public String HelpPage(Model modelHelp) {
        modelHelp.addAttribute("appName", appName);
        return "Help";
    }
    
    @GetMapping("/Locations/buchen")
    public String BuchenPage(Model modelRegister) {
        modelRegister.addAttribute("appName", appName);
        return "buchen";
    } 
    
}
