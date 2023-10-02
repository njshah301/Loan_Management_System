package com.luma.Repository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.luma.model.Employee;
import com.luma.repository.EmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByUsernameAndPassword() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setUsername("testuser");
        employee.setPassword("testpassword");

        // Mock the findByUsernameAndPassword method
        when(employeeRepository.findByUsernameAndPassword("testuser", "testpassword")).thenReturn(Optional.of(employee));

        // Call the method you want to test
        Optional<Employee> foundEmployee = employeeRepository.findByUsernameAndPassword("testuser", "testpassword");

        // Assertions
        assertTrue(foundEmployee.isPresent());
        assertEquals("testuser", foundEmployee.get().getUsername());
        assertEquals("testpassword", foundEmployee.get().getPassword());

        // Verify that the method was called with the expected arguments
        verify(employeeRepository).findByUsernameAndPassword("testuser", "testpassword");
    }

    @Test
    public void testFindByEmpid() {
        // Create a sample employee
        Employee employee = new Employee();
        employee.setEmpid(1L);

        // Mock the findByEmpid method
        when(employeeRepository.findByEmpid(1L)).thenReturn(Optional.of(employee));

        // Call the method you want to test
        Optional<Employee> foundEmployee = employeeRepository.findByEmpid(1L);

        // Assertions
        assertTrue(foundEmployee.isPresent());
        assertEquals(1L, foundEmployee.get().getEmpid());

        // Verify that the method was called with the expected argument
        verify(employeeRepository).findByEmpid(1L);
    }
}
