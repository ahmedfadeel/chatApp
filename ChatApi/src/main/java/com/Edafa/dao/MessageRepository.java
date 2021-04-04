package com.Edafa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Edafa.model.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
	
	/*
	 * load messages by sendeName
	 * load messages by both sender and reciver 
	 * reciever  sender
	 * */

	@Query("SELECT m.text FROM Message m WHERE m.sender = ?1  ")
    public List<String>  findBySender(String sender );
	
	@Query("SELECT m.text FROM Message m WHERE  m.sender = ?1 and   m.reciever = ?2  or  m.sender = ?2 and   m.reciever = ?1")
    public List<String>  findBySender_AndReciver(String sender ,String reciever);
	

}