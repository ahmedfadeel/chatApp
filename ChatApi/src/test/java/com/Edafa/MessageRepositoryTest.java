package com.Edafa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.Edafa.dao.MessageRepository;
import com.Edafa.model.Message;
import com.Edafa.service.MessageService;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class MessageRepositoryTest {
	
	

	@Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private MessageRepository repo;
	    
	  //  @Autowired MessageService service;
	    /*
	    @Test
	    public void testCreatemessage() {
	    	List list=new ArrayList<Message>() ;
	    	Message msg2=new Message();
	    	
	    	msg2.setReciever("Hisham");
	    	msg2.setSender("ahmed");
	    	msg2.setText("hi");
	    	
	    	Message msg3=new Message();
	    	msg3.setReciever("Hisham");
	    	msg3.setSender("ahmed");
	    	msg3.setText("welcome");
	    	
	    	Message msg4=new Message();
	    	msg4.setReciever("Hisham");
	    	msg4.setSender("ahmed");
	    	msg4.setText("how are you ");
	    	
	    	list.add(msg2);
	    	list.add(msg3);
	    	list.add(msg4);M
	    	
	      List saved=repo.saveAll(list);
	      
	     
	      
	      assertThat(saved.size()).isEqualTo(3);
	    }
	    
	    @Test
	    public void testGetMessagesbySender() {
	    	List messages= repo.findBySender("ahmed");
	    	 assertThat(messages.size() > 0);
	    }
	    */
	  
	    
	    
	    /*
	    @Test
	    public void testSaveNull() {
	    	 Message msg=null;
	    	 
	    	  Message saved= repo.save(msg);
	    	  assertThat(saved== null);
	    	     	 
	    }
	    
	    */
	    

}
