package com.example.demo.ServiceInterface;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.History;
import com.example.demo.model.Instances;

public interface HistoryInterface {
	public List<History> getAllHistory();
	public ResponseEntity<History> ManageHistory(Instances i,String used,String reason);

}
