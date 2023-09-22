package com.luma.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luma.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional <Employee> findByUsernameAndPassword(String username, String password);

	Optional <Employee> findByEmpid(Long empid);

}
