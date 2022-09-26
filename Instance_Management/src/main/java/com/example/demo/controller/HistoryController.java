package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.History;

import com.example.demo.services.HistoryService;


@RestController
public class HistoryController {
	@Autowired
	private HistoryService repo;
	@GetMapping("/history")
	public List<History> getAllHistory(){
		return repo.getAllHistory();
	}

}
