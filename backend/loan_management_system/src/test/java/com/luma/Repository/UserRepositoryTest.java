package com.luma.Repository;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.User;
import com.luma.repository.UserRepository;

@SpringBootTest
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByUsername() {
        // Create a sample user
        User user = new User();
        user.setUsername("testuser");

        // Mock the findByUsername method
        when(userRepository.findByUsername("testuser")).thenReturn(Optional.of(user));

        // Call the method you want to test
        Optional<User> foundUser = userRepository.findByUsername("testuser");

        // Assertions
        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());

        // Verify that the method was called with the expected argument
        verify(userRepository).findByUsername("testuser");
    }

    @Test
    public void testFindByEmail() {
        // Create a sample user
        User user = new User();
        user.setEmail("test@example.com");

        // Mock the findByEmail method
        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        // Call the method you want to test
        Optional<User> foundUser = userRepository.findByEmail("test@example.com");

        // Assertions
        assertTrue(foundUser.isPresent());
        assertEquals("test@example.com", foundUser.get().getEmail());

        // Verify that the method was called with the expected argument
        verify(userRepository).findByEmail("test@example.com");
    }

    @Test
    public void testFindByUsernameOrEmail() {
        // Create a sample user
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("test@example.com");

        // Mock the findByUsernameOrEmail method
        when(userRepository.findByUsernameOrEmail("testuser", "test@example.com")).thenReturn(Optional.of(user));

        // Call the method you want to test
        Optional<User> foundUser = userRepository.findByUsernameOrEmail("testuser", "test@example.com");

        // Assertions
        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
        assertEquals("test@example.com", foundUser.get().getEmail());

        // Verify that the method was called with the expected arguments
        verify(userRepository).findByUsernameOrEmail("testuser", "test@example.com");
    }

    @Test
    public void testExistsByUsername() {
        // Mock the existsByUsername method
        when(userRepository.existsByUsername("testuser")).thenReturn(true);

        // Call the method you want to test
        boolean exists = userRepository.existsByUsername("testuser");

        // Assertion
        assertTrue(exists);

        // Verify that the method was called with the expected argument
        verify(userRepository).existsByUsername("testuser");
    }

    @Test
    public void testExistsByEmail() {
        // Mock the existsByEmail method
        when(userRepository.existsByEmail("test@example.com")).thenReturn(true);

        // Call the method you want to test
        boolean exists = userRepository.existsByEmail("test@example.com");

        // Assertion
        assertTrue(exists);

        // Verify that the method was called with the expected argument
        verify(userRepository).existsByEmail("test@example.com");
    }

    @Test
    public void testExistsByUsernameOrEmail() {
        // Mock the existsByUsernameOrEmail method
        when(userRepository.existsByUsernameOrEmail("testuser", "test@example.com")).thenReturn(true);

        // Call the method you want to test
        boolean exists = userRepository.existsByUsernameOrEmail("testuser", "test@example.com");

        // Assertion
        assertTrue(exists);

        // Verify that the method was called with the expected arguments
        verify(userRepository).existsByUsernameOrEmail("testuser", "test@example.com");
    }
}
