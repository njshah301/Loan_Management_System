package com.luma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luma.model.Employee_Issue_Details;
@Repository
public interface EmployeeIssueDetailsRepository extends JpaRepository<Employee_Issue_Details, Long> {

}
