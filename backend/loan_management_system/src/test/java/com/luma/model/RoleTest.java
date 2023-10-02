package com.luma.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RoleTest {

    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
    }

    @Test
    public void testValidRole() {
        role.setName("ADMIN");

        assertTrue(isValidRole(role));
    }

    @Test
    public void testNullName() {
        assertFalse(isValidRole(role));
    }

    private boolean isValidRole(Role role) {
        return role.getName() != null;
    }

}


