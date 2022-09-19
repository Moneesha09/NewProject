package com.example.demo.controller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Employee;
import com.example.demo.services.EmployeeService;


@RestController
public class EmployeeController {
	@Autowired
	public EmployeeService repos;
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return repos.getAllEmployee();
	}
	@PostMapping("/employees")
	public Employee createInst(@RequestBody Employee i) {
		return repos.createInst(i);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		return repos.getEmployeeById(id);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		return repos.deleteEmployee(id);
	}
}
