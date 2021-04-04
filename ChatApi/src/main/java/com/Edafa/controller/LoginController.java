package com.Edafa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Edafa.model.LoginUser;
import com.Edafa.service.MyUserDetailsService;



@Controller
public class LoginController {
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	MyUserDetailsService userDetailsService;
   
	   @PostMapping("/auth")
	    public String auth( @ModelAttribute LoginUser loggedUser  , Model model) throws Exception {
		    System.out.println("in authetication");
		    logger.debug("in post log in ");
		    logger.info("in post log in "); 
		 
		   try {
				   SecurityContextHolder.getContext().setAuthentication(
							  new UsernamePasswordAuthenticationToken(loggedUser.getUsername(), loggedUser.getPassword()));
					}
					catch(BadCredentialsException badCredEx) {
						
						 throw new Exception ("bad userName or password ");
					}
					
					
					
					return "chat";
	    }
	 
	  
	    
	    @GetMapping("/login")
	    public String viewLoginPage( Model model  ) {
	    	logger.info("in login ");
	    	 model.addAttribute("userLogin", new LoginUser());    
	        return "login";
	    } 
	
}
