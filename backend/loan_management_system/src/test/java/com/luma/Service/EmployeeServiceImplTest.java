package com.luma.Service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luma.model.Employee;
import com.luma.model.dto.EmployeeRegisterDto;
import com.luma.model.dto.LoginDto;
import com.luma.repository.EmployeeRepository;
import com.luma.service.serviceImpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee() {
        // Arrange
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();
        Employee employee = new Employee();

        when(modelMapper.map(any(), eq(Employee.class))).thenReturn(employee);

        // Act
        employeeService.addEmployee(employeeRegisterDto);

        // Assert
        verify(employeeRepository).save(employee);
    }

    @Test
    public void testGetEmployees() {
        // Arrange
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setBirthdate(new Date(2023,9, 25));
        employee.setDepartment("CTO");
        employee.setDesignation("CTO");
        employee.setEmpid(2151587L);
        employee.setGender("Male");
        employee.setName("Nilay");
        employee.setJoiningdate(new Date(2023,9,25));
        employee.setPassword("password");
        employee.setUsername("username");
        employees.add(employee);
       // employees.add(new Employee());
        EmployeeRegisterDto employeeRegisterDto=new EmployeeRegisterDto();
        employeeRegisterDto.setId(1L);
        employeeRegisterDto.setBirthdate(new Date(2023,9, 25));
        employeeRegisterDto.setDepartment("CTO");
        employeeRegisterDto.setDesignation("CTO");
        employeeRegisterDto.setEmpid(2151587L);
        employeeRegisterDto.setGender("Male");
        employeeRegisterDto.setName("Nilay");
        employeeRegisterDto.setJoiningdate(new Date(2023,9,25));
      //  employee.setPassword("password");
        //employee.setUsername("username");
        when(employeeRepository.findAll()).thenReturn(employees);
        when(modelMapper.map(any(), eq(EmployeeRegisterDto.class))).thenReturn(employeeRegisterDto);

        // Act
        List<EmployeeRegisterDto> result = employeeService.getEmployees();

        // Assert
        assertEquals(employees.size(), result.size());
    }

    @Test
    public void testUpdateEmployee() {
        // Arrange
        Long id = 1L;
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();
        Employee existingEmployee = new Employee();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(existingEmployee));

        // Act
        employeeService.updateEmployee(employeeRegisterDto, id);

        // Assert
        verify(employeeRepository).save(existingEmployee);
    }

    @Test
    public void testDeleteEmployee() {
        // Arrange
        Long id = 1L;

        // Act
        employeeService.deleteEmplooyee(id);

        // Assert
        verify(employeeRepository).deleteById(id);
    }

    @Test
    public void testAuthUser_Success() {
        // Arrange
        LoginDto loginDto = new LoginDto();
        loginDto.setUsernameOrEmail("username");
        loginDto.setPassword("password");
        Employee employee = new Employee();

        when(employeeRepository.findByUsernameAndPassword("username", "password")).thenReturn(Optional.of(employee));

        // Act
        ResponseEntity<String> result = employeeService.authUser(loginDto);

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    public void testAuthUser_Failure() {
        // Arrange
        LoginDto loginDto = new LoginDto();
        loginDto.setUsernameOrEmail("username");
        loginDto.setPassword("password");

        when(employeeRepository.findByUsernameAndPassword("username", "password")).thenReturn(Optional.empty());

        // Act
        ResponseEntity<String> result = employeeService.authUser(loginDto);

        // Assert
        assertEquals(HttpStatus.FORBIDDEN, result.getStatusCode());
    }

    @Test
    public void testGetEmployeeById() {
        // Arrange
        Long id = 1L;
        Employee employee = new Employee();
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();

        when(employeeRepository.findById(id)).thenReturn(Optional.of(employee));
        when(modelMapper.map(employee, EmployeeRegisterDto.class)).thenReturn(employeeRegisterDto);

        // Act
        EmployeeRegisterDto result = employeeService.getEmployeesbyId(id);

        // Assert
        assertNotNull(result);
        assertEquals(employeeRegisterDto, result);
    }
}
