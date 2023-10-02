package com.luma.model.dto;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginDtoTest {

    @Test
    public void testLoginDtoWithValidValues() {
        // Create an instance of LoginDto with valid values
        LoginDto loginDto = new LoginDto("sampleUsername", "samplePassword");

        // Verify the values
        assertEquals("sampleUsername", loginDto.getUsernameOrEmail());
        assertEquals("samplePassword", loginDto.getPassword());
    }

    @Test
    public void testLoginDtoWithNullValues() {
        // Create an instance of LoginDto with null values
        LoginDto loginDto = new LoginDto(null, null);

        // Verify that all fields are initially null
        assertNull(loginDto.getUsernameOrEmail());
        assertNull(loginDto.getPassword());
    }
}
