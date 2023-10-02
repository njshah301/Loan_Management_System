package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

    private Item item;

    @BeforeEach
    public void setUp() {
        item = new Item();
    }

    @Test
    public void testValidItem() {
        item.setDescription("Sample description");
        item.setStatus("Available");
        item.setMake("Sample make");
        item.setCategory("Sample category");
        item.setValue(100.0);

        assertTrue(isValidItem(item));
    }

    @Test
    public void testNullDescription() {
        // Description is null
        item.setStatus("Available");
        item.setMake("Sample make");
        item.setCategory("Sample category");
        item.setValue(100.0);

        assertFalse(isValidItem(item));
    }

    @Test
    public void testNullStatus() {
        // Status is null
        item.setDescription("Sample description");
        item.setMake("Sample make");
        item.setCategory("Sample category");
        item.setValue(100.0);

        assertFalse(isValidItem(item));
    }

    @Test
    public void testNullMake() {
        // Make is null
        item.setDescription("Sample description");
        item.setStatus("Available");
        item.setCategory("Sample category");
        item.setValue(100.0);

        assertFalse(isValidItem(item));
    }

    @Test
    public void testNullCategory() {
        // Category is null
        item.setDescription("Sample description");
        item.setStatus("Available");
        item.setMake("Sample make");
        item.setValue(100.0);

        assertFalse(isValidItem(item));
    }

    @Test
    public void testNegativeValue() {
        // Negative item value
        item.setDescription("Sample description");
        item.setStatus("Available");
        item.setMake("Sample make");
        item.setCategory("Sample category");
        item.setValue(-100.0);

        assertFalse(isValidItem(item));
    }

    private boolean isValidItem(Item item) {
        return item.getDescription() != null
            && item.getStatus() != null
            && item.getMake() != null
            && item.getCategory() != null
            && item.getValue() != null
            && item.getValue() >= 0.0;
    }
}

