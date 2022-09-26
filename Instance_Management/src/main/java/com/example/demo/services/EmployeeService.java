package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.ServiceInterface.EmployeeInterface;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
@Service
public class EmployeeService implements EmployeeInterface{
	@Autowired
	public EmployeeRepository repos;
	
	public List<Employee> getAllEmployee(){
		return repos.findAll();
	}
	
	public Employee createInst(@RequestBody Employee i) {
		return repos.save(i);
	}
	
	public ResponseEntity<Employee> getEmployeeById( int id) {
		Employee employee = repos.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		return ResponseEntity.ok(employee);
	}
	public ResponseEntity<Map<String, Boolean>> deleteEmployee( int id){
		Employee employee = repos.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		
		repos.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
