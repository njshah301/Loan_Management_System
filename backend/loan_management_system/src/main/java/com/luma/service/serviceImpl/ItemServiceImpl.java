package com.luma.service.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luma.model.Employee;
import com.luma.model.Item;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.ItemDto;
import com.luma.repository.EmployeeRepository;
import com.luma.repository.ItemRepository;
import com.luma.service.service.ItemService;

import jakarta.validation.Valid;
@Service
public class ItemServiceImpl implements ItemService{
	

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<ItemDto> getItems() {
		// TODO Auto-generated method stub
		List<ItemDto> itemDtos=  itemRepository.findAll().stream().map(item-> convertEntityToDto(item)).collect(Collectors.toList());
		return itemDtos;

	}
	
	public Item convertDtoToEntity(ItemDto itemDto)
	{
		Item item= modelMapper.map(itemDto, Item.class);
		return item;
	}
	
	public ItemDto convertEntityToDto(Item item)
	{
		ItemDto itemDto= modelMapper.map(item, ItemDto.class);
		return itemDto;
	}

	@Override
	public ItemDto getItemsbyId(Long itemid) {
		// TODO Auto-generated method stub
		Item item = itemRepository.findById(itemid).get(); 
        ItemDto itemDto= convertEntityToDto(item);
		return itemDto;
	}
	
	public void addItem(ItemDto itemDto)
	{
		
		itemRepository.save(convertDtoToEntity(itemDto));
	}

	@Override
	public void updateItem(ItemDto itemDto, @Valid Long id) {
		// TODO Auto-generated method stub
		Item item = convertDtoToEntity(itemDto);
		item.setItemid(id);
		itemRepository.save(item);
	}

	@Override
	public void deleteItem(@Valid Long id) {
		// TODO Auto-generated method stub
		itemRepository.deleteById(id);
	}


}