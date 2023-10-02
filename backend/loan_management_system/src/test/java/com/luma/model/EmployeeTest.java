package com.luma.model;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() {
        // Create a mock for Employee_Issue_Details and Employee_Card_Details
        Employee_Issue_Details issueDetailsMock = mock(Employee_Issue_Details.class);
        Employee_Card_Details cardDetailsMock = mock(Employee_Card_Details.class);

        // Create an instance of Employee and set the mock dependencies
        employee = new Employee();
        employee.setEmployee_Issue_Details(Arrays.asList(issueDetailsMock));
        employee.setEmployee_Card_Details(Arrays.asList(cardDetailsMock));
    }

    @Test
    public void testEmployeeId() {
        // Test setting and getting the empid
        Long empid = 12345L;
        employee.setEmpid(empid);
        assertEquals(empid, employee.getEmpid());
    }

    @Test
    public void testEmployeeName() {
        // Test setting and getting the name
        String name = "John Doe";
        employee.setName(name);
        assertEquals(name, employee.getName());
    }

    @Test
    public void testEmployeeGender() {
        // Test setting and getting the gender
        String gender = "Male";
        employee.setGender(gender);
        assertEquals(gender, employee.getGender());
    }

    @Test
    public void testEmployeeBirthdate() {
        // Test setting and getting the birthdate
        Date birthdate = Date.valueOf("1990-01-15");
        employee.setBirthdate(birthdate);
        assertEquals(birthdate, employee.getBirthdate());
    }

    @Test
    public void testEmployeeJoiningDate() {
        // Test setting and getting the joiningdate
        Date joiningdate = Date.valueOf("2021-05-20");
        employee.setJoiningdate(joiningdate);
        assertEquals(joiningdate, employee.getJoiningdate());
    }

    @Test
    public void testEmployeeUsername() {
        // Test setting and getting the username
        String username = "johndoe123";
        employee.setUsername(username);
        assertEquals(username, employee.getUsername());
    }

    @Test
    public void testEmployeePassword() {
        // Test setting and getting the password
        String password = "password123";
        employee.setPassword(password);
        assertEquals(password, employee.getPassword());
    }
}
