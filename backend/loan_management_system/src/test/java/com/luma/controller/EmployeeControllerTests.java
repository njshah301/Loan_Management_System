package com.luma.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;

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
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luma.model.dto.EmployeeRegisterDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeControllerTests {
	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper=new ObjectMapper();

	@Test
	@Order(1)
	public void testGetEmployees() throws Exception {
		mockMvc.perform(get("/api/employee")).andExpect(status().isOk());
	}

	@Test
	@Order(2)
	public void testGetById() throws Exception {
		mockMvc.perform(get("/api/employee/8")).andExpect(status().isOk());
	}

	@Order(3)
	@Test
	public void testAddEmployee() throws Exception {
		EmployeeRegisterDto employee=new EmployeeRegisterDto();
		employee.setName("Subodh Singh");
		employee.setGender("Male");
		employee.setDesignation("Senior Software Manager");
		employee.setDepartment("TCTO");
		employee.setEmpid(7765421L);
		employee.setBirthdate(Date.valueOf("2023-09-07"));
		employee.setJoiningdate(Date.valueOf("2023-09-15"));

		String jsonEmployee=objectMapper.writeValueAsString(employee);

		mockMvc.perform(post("/api/employee").content(jsonEmployee).
				contentType("application/json"))
				.andExpect(status().isCreated());
	}

	@Test
	@Order(4)
	public void testUpdateEmployee() throws Exception {
		EmployeeRegisterDto employee=new EmployeeRegisterDto();
		employee.setName("Subodh Singh Rajput");
		employee.setGender("Male");
		employee.setDesignation("Senior Software Manager");
		employee.setDepartment("TCTO");
		employee.setEmpid(7765421L);
		employee.setBirthdate(Date.valueOf("2023-09-07"));
		employee.setJoiningdate(Date.valueOf("2023-09-15"));

		String jsonEmployee=objectMapper.writeValueAsString(employee);

		mockMvc.perform(put("/api/employee/41").content(jsonEmployee)
				.contentType("application/json"))
		.andExpect(status().isOk());

	}

	@Test
	@Order(6)
	public void testDelete() throws Exception {
		mockMvc.perform(delete("/api/employee/41"))
		.andExpect(status().isOk());
	}
}