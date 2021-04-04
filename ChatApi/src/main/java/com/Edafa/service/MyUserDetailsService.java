package com.Edafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Edafa.dao.UserRepository;
import com.Edafa.model.MyUserDetails;
import com.Edafa.model.User;
@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
    private UserRepository userRepo;
	
	@Override
	public MyUserDetails loadUserByUsername(String userName) 
		throws UsernameNotFoundException {
		 User user = userRepo.findByUserName(userName);
	        if (user == null) {
	            throw new UsernameNotFoundException("User not found");
	        }
	        return new MyUserDetails(user);
	}

}
