package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.Repository.InstancesRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Instances;
@Service
public class InstanceService {
	@Autowired
	private InstancesRepository repo;
	public List<Instances> getAllInstances(){
		return repo.findAll();
	}
	public Instances createInst(@RequestBody Instances i) {
		return repo.save(i);
	}
	public ResponseEntity<Instances> getInstanceById(@PathVariable int iid) {
		Instances employee = repo.findById(iid)
				.orElseThrow(() -> new ResourceNotFoundException("Instance not exist with id :" + iid));
		return ResponseEntity.ok(employee);
	}
	public ResponseEntity<Map<String, Boolean>> deleteInstance(@PathVariable int iid){
		Instances employee = repo.findById(iid)
				.orElseThrow(() -> new ResourceNotFoundException("Instance not exist with id :" + iid));
		
		repo.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
