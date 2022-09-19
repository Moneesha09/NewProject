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
import com.example.demo.model.Instances;
import com.example.demo.model.Teams;
import com.example.demo.services.TeamServices;

@RestController
public class TeamController {
	;
	@Autowired
	private TeamServices repo;
	@GetMapping("/teams")
	public List<Teams> getAllInstances(){
		return repo.getAllInstances();
	}
	
	@PostMapping("/teams")
	public Teams createInst(@RequestBody Teams i) {
		return repo.createInst(i);
	}
	
	@GetMapping("/teams/{iid}")
	public ResponseEntity<Teams> getEmployeeById(@PathVariable int iid) {
		return repo.getEmployeeById(iid);
	}
	@DeleteMapping("/teams/{iid}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int iid){
		return repo.deleteEmployee(iid);
	}
	@GetMapping("/teams/{id}/instances")
	public  List<Instances> getInstanceByDep(@PathVariable int id){
		return repo.getInstanceByDep(id);
	}
	@GetMapping("/teams/{id}/employees")
	public  List<Employee> getEmployeeByDep(@PathVariable int id){
		return repo.getEmployeeByDep(id);
	}



}
