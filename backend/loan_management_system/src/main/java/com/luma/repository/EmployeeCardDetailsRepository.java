package com.luma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.luma.model.Employee_Card_Details;
import com.luma.model.Employee_Issue_Details;
@Repository
public interface EmployeeCardDetailsRepository  extends JpaRepository<Employee_Card_Details, Long> {

	@Query("SELECT u FROM Employee_Card_Details u WHERE u.card_id = ?1")
	Employee_Card_Details findByLoanCard_id(Long card_id);

}
