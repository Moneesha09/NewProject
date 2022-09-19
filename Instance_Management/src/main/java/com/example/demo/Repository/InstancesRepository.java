package com.example.demo.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Instances;

public interface InstancesRepository extends JpaRepository<Instances,Integer> {
	
	

}
