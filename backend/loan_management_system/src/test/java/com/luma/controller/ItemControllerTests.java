package com.luma.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
import com.luma.model.dto.ItemDto;
import com.luma.model.dto.LoanDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ItemControllerTests {
	@Autowired
	private MockMvc mockMvc;
	
	private ObjectMapper objectMapper=new ObjectMapper();
	
	@Test
	@Order(1)
	public void testGetItems() throws Exception {
		mockMvc.perform(get("/api/item")).andExpect(status().isOk());
	}
	
	@Test
	@Order(2)
	public void testGetItemById() throws Exception {
		mockMvc.perform(get("/api/item/11")).andExpect(status().isOk())
		.andExpect(jsonPath("$.category", is("Furniture")));
	}
	
	@Test
	@Order(3)
	public void testGetItemsByCategory() throws Exception {
		mockMvc.perform(get("/api/item/category/Furniture")).andExpect(status().isOk());
	}
	
	@Test
	@Order(4)
	public void testGetItemsByDescription() throws Exception {
		mockMvc.perform(get("/api/item/description/Table")).andExpect(status().isOk());
	}
	
	@Test
	@Order(5)
	public void testAddItem() throws Exception {
		ItemDto item = new ItemDto();
		item.setItemid(13L);
		item.setCategory("Furniture");
		item.setDescription("Chair");
		item.setMake("Plastic");
		item.setStatus("Yes");
		item.setValue("300");
		
		String jsonItem=objectMapper.writeValueAsString(item);

		mockMvc.perform(post("/api/item").content(jsonItem).
				contentType("application/json"))
				.andExpect(status().isCreated());
	}
	
	@Test
	@Order(6)
	public void testUpdateItem() throws Exception {
		ItemDto item = new ItemDto();
		item.setItemid(13L);
		item.setCategory("Furniture");
		item.setDescription("Chair");
		item.setMake("Wooden");
		item.setStatus("Yes");
		item.setValue("700");
		
		String jsonItem=objectMapper.writeValueAsString(item);

		mockMvc.perform(put("/api/item/13").content(jsonItem).
				contentType("application/json"))
				.andExpect(status().isOk());
	}
	
	@Test
	@Order(7)
	public void testDeleteItem() throws Exception {
		mockMvc.perform(delete("/api/item/13"))
				.andExpect(status().isOk());
	}
}
