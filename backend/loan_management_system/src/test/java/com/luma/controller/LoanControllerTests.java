package com.luma.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luma.model.dto.LoanDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoanControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Test
	@Order(1)
	public void testGetLoans() throws Exception {
		mockMvc.perform(get("/api/loans")).andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void testGetLoanById() throws Exception {
		mockMvc.perform(get("/api/loans/12")).andExpect(status().isOk())
		.andExpect(jsonPath("$.loan_type", is("crockery")));
	}
	
	@Test
	@Order(3)
//	@Disabled
	public void testAddLoan() throws Exception {
		LoanDto loan = new LoanDto();
		loan.setLoan_id(17L);
		loan.setLoan_type("crockery");
		loan.setDuration(1);
		
		String jsonEmployee=objectMapper.writeValueAsString(loan);

		mockMvc.perform(post("/api/loans").content(jsonEmployee).
				contentType("application/json"))
				.andExpect(status().isCreated());
	}
	
	@Test
	@Order(4)
//	@Disabled
	public void testEditLoan() throws Exception {
		LoanDto loan = new LoanDto();
		loan.setLoan_id(17L);
		loan.setLoan_type("crockery");
		loan.setDuration(5);
		
		String jsonEmployee=objectMapper.writeValueAsString(loan);

		mockMvc.perform(put("/api/loans/17").content(jsonEmployee).
				contentType("application/json"))
				.andExpect(status().isCreated());
	}
	
	@Test
	@Order(5)
//	@Disabled
	public void testDeleteLoan() throws Exception {
		mockMvc.perform(delete("/api/loans/17"))
				.andExpect(status().isOk());
	}
}
