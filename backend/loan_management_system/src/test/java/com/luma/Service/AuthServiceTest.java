package com.luma.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.luma.model.dto.LoginDto;
import com.luma.security.JwtTokenProvider;
import com.luma.service.serviceImpl.AuthServiceImpl;

public class AuthServiceTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLogin() {
        // Create a mock Authentication object
        Authentication mockAuthentication = mock(Authentication.class);

        // Mock the behavior of authenticationManager.authenticate
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(mockAuthentication);

        // Mock the behavior of jwtTokenProvider.generateToken
        when(jwtTokenProvider.generateToken(mockAuthentication)).thenReturn("mockedToken");

        // Create a mock LoginDto
        LoginDto loginDto = new LoginDto("2151587@BRENS", "2151587@123");

        // Call the login method
        String token = authService.login(loginDto);

        // Verify that authenticationManager.authenticate was called with the expected arguments
        verify(authenticationManager).authenticate(
                argThat(authToken -> {
                    UsernamePasswordAuthenticationToken expectedToken =
                            new UsernamePasswordAuthenticationToken("2151587@BRENS", "2151587@123");
                    return authToken.getClass() == UsernamePasswordAuthenticationToken.class
                            && authToken.getPrincipal().equals(expectedToken.getPrincipal())
                            && authToken.getCredentials().equals(expectedToken.getCredentials());
                })
        );

        // Verify that jwtTokenProvider.generateToken was called with the mock Authentication object
        verify(jwtTokenProvider).generateToken(mockAuthentication);

        // Verify that the SecurityContextHolder is set with the mock Authentication object
        assertSame(mockAuthentication, SecurityContextHolder.getContext().getAuthentication());

        // Verify that the returned token matches the expected value
        assertEquals("mockedToken", token);
    }
}
