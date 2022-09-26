package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.History;


public interface HistoryRepository extends  JpaRepository<History,Integer>{

}
