package com.ty.springbootdemoproject.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.springbootdemoproject.dto.Employee;
import com.ty.springbootdemoproject.dto.ResponseStructure;
import com.ty.springbootdemoproject.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee){
		
	    return service.save(employee);
	}
	
	@PutMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee){
		
	    return service.update(employee);
	}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@PathVariable int id){
		
	    return service.getEmployeeById(id);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll(){
		
	    return service.findAll();
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(@PathVariable int id){
		
	    return service.delete(id);
	}
	
	@GetMapping("/employee-name-email")
	public ResponseEntity<ResponseStructure<Employee>> findByNameAndEmail(@RequestParam String name, @RequestParam String email){
		
		return service.getByNameAndEmail(name, email);
	}
}
