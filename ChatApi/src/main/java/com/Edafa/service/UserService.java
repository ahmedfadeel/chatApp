package com.Edafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Edafa.dao.UserRepository;
import com.Edafa.model.User;
import com.Edafa.uttils.UserAlreadyExistException;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepo;
	
	private boolean isUserExisted(User user) {
		return userRepo.findByUserName(user.getUserName()) != null || 
				userRepo.findByEmail(user.getEmail()) != null;
	} 
	
	public User registerNewUser (User user) throws  UserAlreadyExistException {
		 if (isUserExisted(user)) {
			 throw new UserAlreadyExistException("this user is already exists "+
		     user.getUserName());
			 }
		  System.out.println("called user save method");
			return  userRepo.save(user);
	} 
	
public List<String> getAllUsers_Names(){
	return userRepo.getAllUsers_Names();
} 	
}
