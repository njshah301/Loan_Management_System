package com.luma.service.service;

import java.util.List;

import com.luma.model.dto.ItemDto;

import jakarta.validation.Valid;

public interface ItemService {

	public List<ItemDto> getItems();

	public ItemDto getItemsbyId(Long itemid) ;

	public void addItem(ItemDto itemDto);

	public void updateItem(ItemDto itemDto, @Valid Long id);

	public void deleteItem(@Valid Long id);

}