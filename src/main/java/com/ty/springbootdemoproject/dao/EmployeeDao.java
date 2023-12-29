package com.ty.springbootdemoproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.ty.springbootdemoproject.dto.Employee;
import com.ty.springbootdemoproject.employee_repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee( Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	public Employee findEmployee( int id) {
		
		 Optional<Employee> employee=employeeRepository.findById(id);
		 if(employee.isPresent()) {
			 return employee.get();
		 }
		 else
			 return null;
	}
	
	public List<Employee> getAll(){
		List<Employee> employees=employeeRepository.findAll();
		
		return employees;
	}
	
	public boolean delete(int id) {
		Optional<Employee> employee=employeeRepository.findById(id);
		 if(employee.isPresent()) {
			employeeRepository.deleteById(id);
			return true;
		 }
		 else
			 return false;
	}
	
	public Employee  findByNameAndEmail(String name,String email) {
		
		return employeeRepository.findByNameAndEmail(name, email);
	}
}
