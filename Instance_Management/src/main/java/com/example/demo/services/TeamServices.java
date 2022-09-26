package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Repository.TeamRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.Instances;
import com.example.demo.model.Teams;

import ServiceInterface.TeamsInterface;

@Service
public class TeamServices implements TeamsInterface{
	
	@Autowired
	private TeamRepository repo;
	public List<Teams> getAllInstances(){
		return repo.findAll();
	}
	
	public ResponseEntity<Teams> getEmployeeById(int iid) {
		Teams team = repo.findById(iid)
				.orElseThrow(() -> new ResourceNotFoundException("Team not exist with id :" + iid));
		return ResponseEntity.ok(team);
	}
	
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(int iid){
		Teams team = repo.findById(iid)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + iid));
		
		repo.delete(team);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	public Teams createInst(  @RequestBody Teams i) {
		return repo.save(i);
	}
	public List<Instances> getInstanceByDep(int id){
		 return repo.getInstancesByDep(id);
	}
	public List<Employee> getEmployeeByDep(int id){
		 return repo.getEmployeeByDep(id);
	}
	

}
