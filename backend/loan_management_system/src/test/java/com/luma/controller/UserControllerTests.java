package com.luma.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Test
	@Order(1)
	public void testGetItemsByEmployeeId() throws Exception {
		mockMvc.perform(get("/api/user/1234567")).andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void testGetLoansByEmployeeId() throws Exception {
		mockMvc.perform(get("/api/user/cards/1234567")).andExpect(status().isOk());
	}
}
