package com.Edafa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Edafa.dao.MessageRepository;
import com.Edafa.model.Message;

@Service
public class MessageService {
  
	@Autowired
    private   MessageRepository  _repo;
	
	
	public List<Message>  findBySender(String sender ){
		
		return _repo.findBySender(sender);
	}
	
	 public List<Message>  findBySender_AndReciver(String sender ,String reciever){
		 return _repo.findBySender_AndReciver(sender, reciever);
		 
	 }
	 
	 public Message save(Message msg) {
		 if (msg == null) {
			 return null;
		 }
		 System.out.println("from service "+msg.toString());
		 return _repo.save(msg);
	 }
	
	 
	 
}
