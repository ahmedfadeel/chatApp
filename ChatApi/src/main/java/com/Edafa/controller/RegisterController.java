package com.Edafa.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Edafa.model.LoginUser;
import com.Edafa.model.User;
import com.Edafa.service.UserService;
import com.Edafa.uttils.UserAlreadyExistException;

@Controller
@CrossOrigin("*")
public class RegisterController {

	Logger logger = LoggerFactory.getLogger(RegisterController.class);

	@Autowired
	UserService userService;

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "Register";
	}

	@PostMapping("/process_register")
	public String processRegister(@ModelAttribute User user, Model model) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		try {
			System.out.println("  in process register ");
			userService.registerNewUser(user);

		} catch (UserAlreadyExistException uaeEx) {
			logger.info("in register new user exception  ");
			model.addAttribute("message", "An account for that username/email already exists.");
			return "Register";
		}

		model.addAttribute("userLogin", new LoginUser());
		return "login";
	}

	@GetMapping("/getUsers_names")
	@ResponseBody
	public List<String> getAllUsers() {
		return userService.getAllUsers_Names();
	}
}
