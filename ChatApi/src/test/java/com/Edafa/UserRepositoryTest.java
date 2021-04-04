package com.Edafa;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.Edafa.dao.UserRepository;
import com.Edafa.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	   @Autowired
	    private TestEntityManager entityManager;
	     
	    @Autowired
	    private UserRepository repo;
	
	@Test
	public void testCreateUser() {
	    User user = new User();
	    user.setEmail("ahmedcfadel@gmail.com");
	    user.setPassword("ah1234");
	    user.setUserName("ahmed fadel");
	    
	     
	    User savedUser = repo.save(user);
	     
	    User existUser = entityManager.find(User.class, savedUser.getId());
	     
	    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
	     
	}
}
