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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@ApiResponses(value = @ApiResponse(description = "employee created", responseCode = "201"))
	@Operation(description = "employee saved successfully", summary = "employee saved in the database")
	@PostMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> saveEmployee(@RequestBody Employee employee){
		
	    return service.save(employee);
	}
	
	@ApiResponses(value = @ApiResponse(description = "employee accepected", responseCode = "202"))
	@Operation(description = "employee updated successfully", summary = "employee updated in the database")
	@PutMapping("/employee")
	public ResponseEntity<ResponseStructure<Employee>> updateEmployee(@RequestBody Employee employee){
		
	    return service.update(employee);
	}
	
	@ApiResponses(value = @ApiResponse(description = "employee found", responseCode = "200"))
	@Operation(description = "employee found successfully", summary = "employee fetched from the database based on the id")
	@GetMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<Employee>> findEmployeeById(@PathVariable int id){
		
	    return service.getEmployeeById(id);
	}
	
	@ApiResponses(value = @ApiResponse(description = "all employee found", responseCode = "200"))
	@Operation(description = "all employees found successfully", summary = "all employees fetched from the database")
	@GetMapping("/employee")
	public ResponseEntity<ResponseStructure<List<Employee>>> findAll(){
		
	    return service.findAll();
	}
	
	
	@ApiResponses(value = @ApiResponse(description = "employee deleted", responseCode = "200"))
	@Operation(description = "employee deleted successfully", summary = "employee deleted from the database based on id")
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteEmployeeById(@PathVariable int id){
		
	    return service.delete(id);
	}
	
	@ApiResponses(value = @ApiResponse(description = "employee found", responseCode = "200"))
	@Operation(description = "employee found successfully", summary = "employee fetched from the database based on name and email")
	@GetMapping("/employee-name-email")
	public ResponseEntity<ResponseStructure<Employee>> findByNameAndEmail(@RequestParam String name, @RequestParam String email){
		
		return service.getByNameAndEmail(name, email);
	}
}
