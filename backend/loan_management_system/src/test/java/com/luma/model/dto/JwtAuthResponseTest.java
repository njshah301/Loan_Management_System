package com.luma.model.dto;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class JwtAuthResponseTest {

    @Test
    public void testJwtAuthResponse() {
        // Create an instance of JwtAuthResponse
        JwtAuthResponse jwtResponse = new JwtAuthResponse("sampleAccessToken", "Bearer", "sampleRole");

        // Verify the values
        assertEquals("sampleAccessToken", jwtResponse.getAccessToken());
        assertEquals("Bearer", jwtResponse.getTokenType());
        assertEquals("sampleRole", jwtResponse.getRole());
    }

    @Test
    public void testJwtAuthResponseWithDefaultTokenType() {
        // Create an instance of JwtAuthResponse with the default tokenType
        JwtAuthResponse jwtResponse = new JwtAuthResponse("sampleAccessToken", "Bearer", "sampleRole");

        // Verify the values
        assertEquals("sampleAccessToken", jwtResponse.getAccessToken());
        assertEquals("Bearer", jwtResponse.getTokenType()); // Token type should default to "Bearer"
        assertEquals("sampleRole", jwtResponse.getRole());
    }

    @Test
    public void testJwtAuthResponseWithNullValues() {
        // Create an instance of JwtAuthResponse with null values
        JwtAuthResponse jwtResponse = new JwtAuthResponse(null, null, null);

        // Verify that all fields are initially null
        assertNull(jwtResponse.getAccessToken());
        assertNull(jwtResponse.getTokenType());
        assertNull(jwtResponse.getRole());
    }
}
