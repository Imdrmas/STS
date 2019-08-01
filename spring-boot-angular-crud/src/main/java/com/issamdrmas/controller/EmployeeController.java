package com.issamdrmas.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.issamdrmas.dao.EmployeeRepository;
import com.issamdrmas.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable("id") Long employeeId) {
	  Optional<Employee> employees = employeeRepository.findById(employeeId);
	  return employees;
	}
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId, Employee employee){
	Optional<Employee> employees = employeeRepository.findById(employeeId);
	if (employees.isPresent()) {
		Employee _employee = employees.get();
		_employee.setFirstName(employee.getFirstName());
		_employee.setLastName(employee.getLastName());
		_employee.setEmailId(employee.getEmailId());
		return new ResponseEntity<Employee>(employeeRepository.save(_employee), HttpStatus.OK);
	}
	return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
   }
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) {
		employeeRepository.deleteById(employeeId);
		return new ResponseEntity<String>("Employee deleted", HttpStatus.OK);
	}

}
