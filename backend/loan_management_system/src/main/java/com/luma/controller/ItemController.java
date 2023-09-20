package com.luma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luma.model.dto.ItemDto;
import com.luma.service.service.ItemService;

import jakarta.validation.Valid;

@RequestMapping("/api/item")
@RestController
@CrossOrigin
public class ItemController {
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;
	
	@GetMapping
	public List<ItemDto> getItems()
	{ 
		logger.info("ItemController: Entered inside getItems() method");
		List<ItemDto> itemDtos=itemService.getItems();
		return itemDtos;
	}
	
	@GetMapping(path="{itemid}")
	public ItemDto getItemsById(@PathVariable Long itemid)
	{ 
		logger.info("ItemController: Entered inside getItemsById() method");
		ItemDto itemDto=itemService.getItemsbyId(itemid);
		return itemDto;
	}
	
	@PostMapping
	public ResponseEntity<String> addItem(@Valid @RequestBody ItemDto itemDto)
	{
		logger.info("ItemController: Entered inside addItem() method");
		itemService.addItem(itemDto);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public void updateItem(@Valid @PathVariable Long id,@RequestBody ItemDto itemDto)
	{
		logger.info("ItemController: Entered inside updateItem() method");
		itemService.updateItem(itemDto,id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteItem(@Valid @PathVariable Long id)
	{
		logger.info("ItemController: Entered inside deleteItem() method");
		itemService.deleteItem(id);
	}
}
