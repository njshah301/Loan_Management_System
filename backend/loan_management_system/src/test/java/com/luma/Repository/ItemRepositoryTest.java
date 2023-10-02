package com.luma.Repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.Item;
import com.luma.model.dto.ItemDto;
import com.luma.repository.ItemRepository;
import com.luma.service.serviceImpl.ItemServiceImpl;

@SpringBootTest
public class ItemRepositoryTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Mock
//    @Autowired
    ModelMapper modelMapper;
    public Item convertDtoToEntity(ItemDto item)
	{
		Item itemDto= modelMapper.map(item, Item.class);
		return itemDto;
	}
    @Test
    public void testFindByItemCategory() {
        // Create some test data
        String category = "CategoryA";
        Item item1 = new Item();
        item1.setDescription("description1");
        ItemDto itemDto1=new ItemDto();
        itemDto1.setDescription("description1");
        Item item2 = new Item();
        item2.setDescription("description2");
        ItemDto itemDto2=new ItemDto();
        itemDto2.setDescription("description2");
        List<Item> itemsInCategoryA = new ArrayList<>();
        itemsInCategoryA.add(item1);
        itemsInCategoryA.add(item2);
       
        // Define the behavior of the mocked repository method
        when(itemRepository.findByItemCategory(category)).thenReturn(itemsInCategoryA);
        when(modelMapper.map(item1, ItemDto.class)).thenReturn(itemDto1);
        when(modelMapper.map(item2, ItemDto.class)).thenReturn(itemDto2);

        // Perform the service method call that uses the repository
        List<ItemDto> result = itemService.getItemsByCategory(category);

        // Assert that the correct items are returned
        assertThat(result).containsExactlyInAnyOrder(itemDto1, itemDto2);
    }

    @Test
    public void testFindByItemDescription() {
        // Create some test data
        Item item = new Item();
        item.setItemid(1L);
        item.setCategory("CatagoryX");
        item.setDescription("DescriptionX");
        ItemDto itemDto=new ItemDto();
        itemDto.setCategory("CatagoryX");
        itemDto.setDescription("DescriptionX");
        itemDto.setItemid(1L);
        // Define the behavior of the mocked repository method
        when(itemRepository.findByItemDescription("DescriptionX")).thenReturn(item);
        when(modelMapper.map(item, ItemDto.class)).thenReturn(itemDto);

        // Perform the service method call that uses the repository
        ItemDto result = itemService.getItemsByDescription("DescriptionX");

        // Assert that the correct item is returned
        assertThat(result).isEqualTo(itemDto);
    }
}
