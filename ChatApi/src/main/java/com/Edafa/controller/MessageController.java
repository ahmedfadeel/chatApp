package com.Edafa.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Edafa.model.Message;
import com.Edafa.service.MessageService;


@CrossOrigin("*")
@Controller
public class MessageController {
	Logger logger = LoggerFactory.getLogger(MessageController.class);

	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;

	@Autowired
	MessageService _service;
	
	@ResponseBody
	@PostMapping("/save-Msg")
	public Message  saveMsg(@RequestBody Message msg) {
		logger.info(msg.toString());
		Message ms_g=_service.save(msg);
		logger.info(ms_g.toString());
		return ms_g;
	} 
    
	@MessageMapping("/send.message")
	public Message   reply(@Payload Message message, Principal user) {
		  _service.save(message);
		 logger.info(message.toString());
		this.simpMessagingTemplate.convertAndSend("/queue/chats-" + message.getReciever(), message);
		return message;
	}
    
	@ResponseBody
	@GetMapping("/getMessages")
	public List<Message> getMessages_BySender(@RequestParam String  sender , @RequestParam String  reciever){
		 String sender_=sender;
		 String reciever_=reciever;
		 
		 List<Message> messages=_service.findBySender_AndReciver(sender_ , reciever_);
		 logger.info(messages.size() +" " + sender);
		 return messages;
	}
	
	
	

}
