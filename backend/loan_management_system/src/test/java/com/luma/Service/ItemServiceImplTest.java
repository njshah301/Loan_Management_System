package com.luma.Service;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import com.luma.model.Item;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.ItemDto;
import com.luma.repository.ItemRepository;
import com.luma.service.serviceImpl.ItemServiceImpl;

public class ItemServiceImplTest {

    @Mock
    private ItemRepository itemRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetItems() {
        // Create a list of items
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item();
        item1.setItemid(1L);
        Item item2 = new Item();
        item2.setItemid(1L);
        itemList.add(item1);
        itemList.add(item2);
        
        ItemDto itemDto= new ItemDto();
        itemDto.setItemid(1L);
        // Mock the behavior of the item repository
        when(itemRepository.findAll()).thenReturn(itemList);
        when(modelMapper.map(any(), eq(ItemDto.class))).thenReturn(itemDto);

        // Call the service method
        List<ItemDto> result = itemService.getItems();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getItemid());
        assertEquals(1L, result.get(1).getItemid());

        // Verify that the repository method was called
        verify(itemRepository).findAll();
    }

    @Test
    public void testGetItemsbyId() {
        // Create an item
        Item item = new Item();
        item.setItemid(1L);
        ItemDto itemDto=new ItemDto();
        itemDto.setItemid(1L);
        // Mock the behavior of the item repository
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

        // Mock the behavior of the modelMapper
        when(modelMapper.map(item, ItemDto.class)).thenReturn(itemDto);

        // Call the service method
        ItemDto result = itemService.getItemsbyId(1L);

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getItemid());

        // Verify that the repository method was called
        verify(itemRepository).findById(1L);
    }

    @Test
    public void testGetItemsByCategory() {
        // Create a list of items
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item();
        item1.setItemid(1L);
        Item item2 = new Item();
        item2.setItemid(1L);
        itemList.add(item1);
        itemList.add(item2);
        
        ItemDto itemDto = new ItemDto();
        itemDto.setItemid(1L);

        // Mock the behavior of the item repository
        when(itemRepository.findByItemCategory("Electronics")).thenReturn(itemList);

        // Mock the behavior of the modelMapper
        when(modelMapper.map(any(Item.class), eq(ItemDto.class))).thenReturn(itemDto);

        // Call the service method
        List<ItemDto> result = itemService.getItemsByCategory("Electronics");

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getItemid());
        assertEquals(1L, result.get(1).getItemid());

        // Verify that the repository method was called
        verify(itemRepository).findByItemCategory("Electronics");
    }

    @Test
    public void testGetItemsByDescription() {
        // Create an item
        Item item = new Item();
        item.setItemid(1L);
        
        ItemDto itemDto = new ItemDto();
        itemDto.setItemid(1L);
        // Mock the behavior of the item repository
        when(itemRepository.findByItemDescription("Laptop")).thenReturn(item);

        // Mock the behavior of the modelMapper
        when(modelMapper.map(item, ItemDto.class)).thenReturn(itemDto);

        // Call the service method
        ItemDto result = itemService.getItemsByDescription("Laptop");

        // Verify the result
        assertNotNull(result);
        assertEquals(1L, result.getItemid());

        // Verify that the repository method was called
        verify(itemRepository).findByItemDescription("Laptop");
    }

    @Test
    public void testAddItem() {
        // Create an item DTO
        ItemDto itemDto = new ItemDto();
        itemDto.setItemid(1L);
        Item item = new Item();
        item.setItemid(1L);
        
        when(modelMapper.map(itemDto, Item.class)).thenReturn(item);

        // Call the service method
        itemService.addItem(itemDto);

        // Verify that the repository method was called
        verify(itemRepository).save(any(Item.class));
    }

    @Test
    public void testUpdateItem() {
    	Item item = new Item();
    	item.setItemid(1L);
        // Create an item DTO
        ItemDto itemDto = new ItemDto();
        itemDto.setItemid(1L);
        when(modelMapper.map(any(), eq(Item.class))).thenReturn(item);

        // Call the service method
        itemService.updateItem(itemDto, 1L);

        // Verify that the repository method was called
        verify(itemRepository).save(any(Item.class));
    }

    @Test
    public void testDeleteItem() {
        // Create an item
        Item item = new Item();
        item.setItemid(1L);

        // Mock the behavior of the item repository
        when(itemRepository.findById(1L)).thenReturn(Optional.of(item));

        // Call the service method
        itemService.deleteItem(1L);

        // Verify that the repository methods were called
        verify(itemRepository).deleteById(1L);
    }
}
