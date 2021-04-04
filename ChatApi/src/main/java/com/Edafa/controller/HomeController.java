package com.Edafa.controller;


import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.Edafa.model.LoginUser;
@Controller
@CrossOrigin("*")
public class HomeController {
	Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   
	 @GetMapping({"/" , "/home"})
	    public String showRegistrationForm(Model model) {
		 model.addAttribute("userLogin", new LoginUser());  
	        return "login";
	    } 
	    
	 @GetMapping("/chat")
	    public String showChattingRoom( Principal principal , Model model  ) {
	        String userNmae=principal.getName();
	        model.addAttribute("name", userNmae);
	        return "chat";
	    }
   
  
}
