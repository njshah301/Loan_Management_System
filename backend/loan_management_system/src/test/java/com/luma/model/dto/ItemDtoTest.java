//package com.luma.model.dto;


package com.luma.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemDtoTest {

    private ItemDto itemDto;

    @BeforeEach
    public void setUp() {
        itemDto = new ItemDto();
        itemDto.setItemid(1L);
        itemDto.setDescription("Test Description");
        itemDto.setStatus("Test Status");
        itemDto.setMake("Test Make");
        itemDto.setCategory("Test Category");
        itemDto.setValue("Test Value");
    }

    @Test
    public void testItemDtoFields() {
        assertEquals(1L, itemDto.getItemid());
        assertEquals("Test Description", itemDto.getDescription());
        assertEquals("Test Status", itemDto.getStatus());
        assertEquals("Test Make", itemDto.getMake());
        assertEquals("Test Category", itemDto.getCategory());
        assertEquals("Test Value", itemDto.getValue());
    }

    @Test
    public void testItemDtoNotNullFields() {
        assertNotNull(itemDto.getItemid());
        assertNotNull(itemDto.getDescription());
        assertNotNull(itemDto.getStatus());
        assertNotNull(itemDto.getMake());
        assertNotNull(itemDto.getCategory());
        assertNotNull(itemDto.getValue());
    }
    @Test
    public void testItemDtoNullableFields() {
        itemDto.setItemid(null);
       itemDto.setDescription(null);
       itemDto.setStatus(null);
        itemDto.setMake(null);
        itemDto.setCategory(null);
       itemDto.setValue(null);
       assertNull(itemDto.getItemid());
       assertNull(itemDto.getDescription());
       assertNull(itemDto.getStatus());
       assertNull(itemDto.getMake());
       assertNull(itemDto.getCategory());
       assertNull(itemDto.getValue());
    }
}