package com.ty.springbootdemoproject.employee_repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ty.springbootdemoproject.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

	@Query("select e from Employee e where e.name=?1 and e.email=?2")
	public Employee findByNameAndEmail(String name, String email);
	
}
