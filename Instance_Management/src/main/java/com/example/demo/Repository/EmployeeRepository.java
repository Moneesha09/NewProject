package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;
//import com.example.demo.model.Instance;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
