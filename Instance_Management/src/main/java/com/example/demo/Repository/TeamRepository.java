package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Employee;
import com.example.demo.model.Instances;
import com.example.demo.model.Teams;



public interface TeamRepository extends JpaRepository<Teams,Integer>{
	
	@Query("select instances from Teams t where t.id=?1 ")
	List<Instances> getInstancesByDep(int id);
	@Query("select employees from Teams t where t.id=?1 ")
	List<Employee> getEmployeeByDep(int id);

}
