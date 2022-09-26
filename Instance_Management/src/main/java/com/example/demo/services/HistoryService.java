package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.HistoryRepository;
import com.example.demo.model.History;
import com.example.demo.model.Instances;

import ServiceInterface.HistoryInterface;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

@Service
public class HistoryService implements HistoryInterface{
	@Autowired
	private HistoryRepository repo;
public List<History> getAllHistory(){
		
		return repo.findAll();
	}
public ResponseEntity<History> ManageHistory(Instances i,String used,String reason){
	History h = new History() ;
	  
	 long millis=System.currentTimeMillis();  
	 java.sql.Date date = new java.sql.Date(millis);  
	h.setInstances(i);
	h.setUsed(used);
	h.setReason("Testing");
	h.setTime(date);
	

	return ResponseEntity.ok(repo.save(h));
}
public ResponseEntity<History> ManageTime(Instances i){
	History h = new History() ;
	 java.util.Date date = new java.util.Date();  
	 h.setTotime(date);

	return ResponseEntity.ok(repo.save(h));
}

}
