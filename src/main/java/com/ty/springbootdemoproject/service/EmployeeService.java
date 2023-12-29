package com.ty.springbootdemoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ty.springbootdemoproject.dao.EmployeeDao;
import com.ty.springbootdemoproject.dto.Employee;
import com.ty.springbootdemoproject.dto.ResponseStructure;
import com.ty.springbootdemoproject.exception.IdNotFoundException;
import com.ty.springbootdemoproject.exception.NameEmailNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	public ResponseEntity<ResponseStructure<Employee>> save(Employee employee) {

		Employee employee2 = dao.saveEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatuCode(HttpStatus.CREATED.value());
		structure.setMessage("employee saved successfully");
		structure.setData(employee2);

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<Employee>> update(Employee employee) {

		Employee employee2 = dao.updateEmployee(employee);

		ResponseStructure<Employee> structure = new ResponseStructure<>();
		structure.setStatuCode(HttpStatus.ACCEPTED.value());
		structure.setMessage("employee updated successfully");
		structure.setData(employee2);

		return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.ACCEPTED);
	}

	public ResponseEntity<ResponseStructure<Employee>> getEmployeeById(int id) {

		Employee employee2 = dao.findEmployee(id);
		if (employee2 != null) {
			ResponseStructure<Employee> structure = new ResponseStructure<>();
			structure.setStatuCode(HttpStatus.OK.value());
			structure.setMessage("employee found");
			structure.setData(employee2);
			return new ResponseEntity<ResponseStructure<Employee>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException("Invalid id: " + id);
		}
	}

	public ResponseEntity<ResponseStructure<List<Employee>>> findAll() {

		List<Employee> employees = dao.getAll();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		structure.setStatuCode(HttpStatus.OK.value());
		structure.setMessage("found");
		structure.setData(employees);
		return new ResponseEntity<ResponseStructure<List<Employee>>>(structure, HttpStatus.OK);

	}
	

	public ResponseEntity<ResponseStructure<String>> delete( int id){
		boolean res=dao.delete(id);
		if(res) {
			ResponseStructure<String> structure=new ResponseStructure<>();
			structure.setStatuCode(HttpStatus.OK.value());
			structure.setMessage("found");
			structure.setData("deleted successfully");
			return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("invalid id: " + id );
		}
	}

	
	public ResponseEntity<ResponseStructure<Employee>> getByNameAndEmail(String name, String email){
		Employee employee=dao.findByNameAndEmail(name, email);
		
		if(employee!=null) {
			ResponseStructure<Employee> structure= new ResponseStructure<>();
			structure.setStatuCode(HttpStatus.OK.value());
			structure.setMessage("found");
			structure.setData(employee);
			return  new ResponseEntity<ResponseStructure<Employee>>(structure,HttpStatus.OK);
		}
		else {
			throw new NameEmailNotFoundException("Invalid Name Or Email: " + name + ", " + email);
		}
	}
	
}
