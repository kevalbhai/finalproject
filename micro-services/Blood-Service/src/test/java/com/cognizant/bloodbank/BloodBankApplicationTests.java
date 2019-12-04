package com.cognizant.bloodbank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class BloodBankApplicationTests {

	@Autowired
	private MockMvc mvc;

	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetExperience() throws Exception{
	ResultActions resultActions = mvc.perform(get("/experience"));
	resultActions.andExpect(status().isOk());
	resultActions.andExpect(jsonPath("$").exists());
	}
	
	@Test
	public void testGetBloodRequirement() throws Exception{
	ResultActions resultActions = mvc.perform(get("/bloodrequire"));
	resultActions.andExpect(status().isOk());
	resultActions.andExpect(jsonPath("$").exists());
	}
}
