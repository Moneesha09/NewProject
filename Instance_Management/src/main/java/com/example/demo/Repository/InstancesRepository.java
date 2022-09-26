package com.example.demo.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.History;
import com.example.demo.model.Instances;




public interface InstancesRepository extends JpaRepository<Instances,Integer> {
	@Query("select history from Instances t where t.id=?1 ")
	List<History> getHistoryByIns(int id);
	

}
