package com.luma.model.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class EmployeeRegisterDtoTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testValidEmployeeRegisterDto() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(1L);
        dto.setName("John Doe");
        dto.setDesignation("Manager");
        dto.setDepartment("HR");
        dto.setGender("Male");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInvalidEmployeeRegisterDto() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(7, violations.size()); // Check for all 6 expected violations
    }

    @Test
    public void testMissingEmpid() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setName("Jane Doe");
        dto.setDesignation("Manager");
        dto.setDepartment("HR");
        dto.setGender("Female");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Enter Employee ID", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidGender() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(2L);
        dto.setName("Bob");
        dto.setDesignation("Developer");
        dto.setDepartment("IT");
        dto.setGender("Unknown");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
//        assertEquals("must match (Male|Female|Other)", violations.iterator().next().getMessage());
    }

    @Test
    public void testMissingBirthdateAndJoiningdate() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(3L);
        dto.setName("Alice");
        dto.setDesignation("Designer");
        dto.setDepartment("Creative");
        dto.setGender("Female");

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(2, violations.size());
        // Check messages for missing birthdate and joiningdate
        assertTrue(violations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Please choose your birthdate")));
        assertTrue(violations.stream()
                .anyMatch(violation -> violation.getMessage().equals("Please choose your joinig date")));
    }

    // Additional test cases for other validation scenarios
    @Test
    public void testBlankName() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(4L);
        dto.setName("");
        dto.setDesignation("Manager");
        dto.setDepartment("HR");
        dto.setGender("Male");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Name must not be NULL", violations.iterator().next().getMessage());
    }

    @Test
    public void testBlankDesignation() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(5L);
        dto.setName("Ella");
        dto.setDesignation("");
        dto.setDepartment("Sales");
        dto.setGender("Female");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Designation must not be NULL", violations.iterator().next().getMessage());
    }

    @Test
    public void testBlankDepartment() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(6L);
        dto.setName("Mike");
        dto.setDesignation("Engineer");
        dto.setDepartment("");
        dto.setGender("Male");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Department must not be NULL", violations.iterator().next().getMessage());
    }

    @Test
    public void testInvalidGenderPattern() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(7L);
        dto.setName("Sara");
        dto.setDesignation("Analyst");
        dto.setDepartment("Finance");
        dto.setGender("Hey");
        dto.setBirthdate(new Date(System.currentTimeMillis()));
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
      //  assertEquals("must match (Male|Female|Other)", violations.iterator().next().getMessage());
    }

    @Test
    public void testMissingBirthdate() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(8L);
        dto.setName("Tom");
        dto.setDesignation("Designer");
        dto.setDepartment("Creative");
        dto.setGender("Male");
        dto.setJoiningdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Please choose your birthdate", violations.iterator().next().getMessage());
    }

    @Test
    public void testMissingJoiningdate() {
        EmployeeRegisterDto dto = new EmployeeRegisterDto();
        dto.setEmpid(9L);
        dto.setName("Anna");
        dto.setDesignation("Manager");
        dto.setDepartment("HR");
        dto.setGender("Female");
        dto.setBirthdate(new Date(System.currentTimeMillis()));

        Set<ConstraintViolation<EmployeeRegisterDto>> violations = validator.validate(dto);

        assertEquals(1, violations.size());
        assertEquals("Please choose your joinig date", violations.iterator().next().getMessage());
    }
}
