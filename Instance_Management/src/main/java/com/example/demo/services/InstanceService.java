package com.example.demo.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.Repository.InstancesRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.model.History;
import com.example.demo.model.Instances;
import com.example.demo.services.HistoryService;
@Service
public class InstanceService {
	@Autowired
	private InstancesRepository repo;
	@Autowired
	private HistoryService his;
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
	/*public   void updateInstance(int id,Instances i) {
		Instances iDb=repo.findById(id).get();
		System.out.println(iDb.toString());
		iDb.setName(i.getName());
		iDb.setState(true);
		iDb.setUsed(i.getUsed());
		repo.save(iDb);
		
	
	}*/
	 public ResponseEntity<Instances> updateEmployee(@PathVariable int iid,  @RequestBody Instances ins) {
	      Instances instance = repo.findById(iid).orElseThrow(() -> new ResourceNotFoundException("Instance with the id - " + iid + " not exist"));
	      instance.setName(ins.getName()); 
	      instance.setState(!ins.getState());
	      instance.setEmloyee(ins.getEmloyee());
	      instance.setTeams(ins.getTeams());
	      if(!ins.getState()) {
	      instance.setUsed(ins.getUsed());
	      instance.setReason(instance.getReason());
	      his.ManageHistory(instance, instance.getUsed(),instance.getReason());
	     
	    
	      }else {
	    	  instance.setUsed(null);
	    	  instance.setReason(null);
	    	  his.ManageTime(instance);
	      }
	     
	     
	        return ResponseEntity.ok(repo.save(instance));
	    }
	 public List<History> getHistoryByIns(int id){
		 return repo.getHistoryByIns(id);
	}
	public Instances saveOrUpdateAlien(@RequestBody Instances alien)
	{
		
		repo.save(alien);
		return alien;
	}



}
