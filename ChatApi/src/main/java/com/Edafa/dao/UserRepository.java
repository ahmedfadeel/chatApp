package com.Edafa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Edafa.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
	
	@Query("SELECT u.userName  FROM User u ")
	public List<String> getAllUsers_Names();
  	
}
