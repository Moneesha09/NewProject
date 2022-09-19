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
import com.example.demo.model.Instances;
import com.example.demo.services.InstanceService;

@RestController
public class InstancesController {
	@Autowired
	private InstanceService repo;
	@GetMapping("/instance")
	public List<Instances> getAllInstances(){
		return repo.getAllInstances();
	}
	
	@PostMapping("/instance")
	public Instances createInst(@RequestBody Instances i) {
		return repo.createInst(i);
	}
	
	@GetMapping("/instance/{iid}")
	public ResponseEntity<Instances> getInstanceById(@PathVariable int iid) {
		return repo.getInstanceById(iid);
	}
	@DeleteMapping("/instance/{iid}")
	public ResponseEntity<Map<String, Boolean>> deleteInstance(@PathVariable int iid){
		return repo.deleteInstance(iid);
	}

	

}
