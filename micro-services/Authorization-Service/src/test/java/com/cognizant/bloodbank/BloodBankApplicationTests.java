package com.cognizant.bloodbank;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cognizant.bloodbank.exception.UserAlreadyExistsException;
import com.cognizant.bloodbank.model.User;
import com.cognizant.bloodbank.repository.UserRepository;
import com.cognizant.bloodbank.security.AppUserDetailsService;
import com.cognizant.bloodbank.service.UserDetailsService;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BloodBankApplicationTests {

	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
    UserRepository userRepository;

	
	@Test
	public void contextLoads() {
	}
	
    @Test
    public void testSignUp() throws UserAlreadyExistsException{
    User user = new User();
    user.setAge(30);
    user.setArea("Rajkot");
    user.setBloodgroup("AB+");
    user.setBloodrequireList(null);
    user.setContact(1234567890);
    user.setEmail("test@gmail.com");
    user.setExperienceList(null);
    user.setFirstname("Test");
    user.setLastname("case");
    user.setGender("Female");
    user.setPassword("test");
    user.setPincode(900000);
    user.setState("Gujarat");
    user.setWeight(60);
    userDetailsService.signup(user);
    Assert.assertTrue(userRepository.findByEmail(user.getEmail())!=null);
    }
    
    @Test
    public void testLoadByUserName() {
       
        User user = userRepository.findByEmail("admin");
        String expected = "$2a$10$jk8h9rr/gUI.G9g1OSNDiuZeuv/4HiqwX8NQqwde2RcTr/c8Y91Ma";
        assertEquals(expected, user.getPassword());
        
    }
    
    @Test
    public void testLoadByUserNameWithInvalidCredentials() {
       
        User user = userRepository.findByEmail("admin");
        String expected = "$2a$10$jk8h9rr/gUI.G9g1OSNDiZeuv/HiqwX8NQqwde2RcTr/c8Y91Ma";
        assertEquals(expected, user.getPassword());
        
    }

    
}