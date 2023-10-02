package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
    }

    @Test
    public void testValidUser() {
        user.setName("John Doe");
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");

        Set<Role> roles = new HashSet<>();
        Role role1 = mock(Role.class);
        Role role2 = mock(Role.class);
        roles.add(role1);
        roles.add(role2);

        user.setRoles(roles);

        assertTrue(isValidUser(user));
    }

    @Test
    public void testNullName() {
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");

        assertFalse(isValidUser(user));
    }

    @Test
    public void testNullUsername() {
        user.setName("John Doe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");

        assertFalse(isValidUser(user));
    }

    @Test
    public void testNullEmail() {
        user.setName("John Doe");
        user.setUsername("johndoe");
        user.setPassword("password");

        assertFalse(isValidUser(user));
    }

    @Test
    public void testNullPassword() {
        user.setName("John Doe");
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");

        assertFalse(isValidUser(user));
    }

    @Test
    public void testNullRoles() {
        user.setName("John Doe");
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");
        user.setPassword("password");

        assertFalse(isValidUser(user));
    }

    private boolean isValidUser(User user) {
        return user.getName() != null
            && user.getUsername() != null
            && user.getEmail() != null
            && user.getPassword() != null
            && user.getRoles() != null
            && !user.getRoles().isEmpty();
    }
}

