package com.Edafa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "messages")
public class Message {
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String text;
	
	@Column(name = "reciever_name", nullable = false)
    private String reciever;
	
	@Column(name = "sender_name", nullable = false)
    private String sender;
    
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciver) {
		this.reciever = reciver;
	}

	public  String getText() {
		return text;
	}

	public void setText(String name) {
		this.text = name;
	}
    
	public String toString() {
		return "sender is  " + this.getSender() + 
				"  reciever is  " + this.getReciever() +
				"message is  " +this.getText();
	}
}