package com.luma.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.Role;
import com.luma.repository.RoleRepository;

@SpringBootTest
public class RoleRepositoryTest {

    @Mock
    private RoleRepository roleRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByName() {
        // Create a sample role
        Role role = new Role();
        role.setName("USER");

        // Mock the findByName method
        when(roleRepository.findByName("USER")).thenReturn(Optional.of(role));

        // Call the method you want to test
        Optional<Role> foundRole = roleRepository.findByName("USER");

        // Assertions
        assertTrue(foundRole.isPresent());
        assertEquals("USER", foundRole.get().getName());

        // Verify that the method was called with the expected argument
        verify(roleRepository).findByName("USER");
    }
}
