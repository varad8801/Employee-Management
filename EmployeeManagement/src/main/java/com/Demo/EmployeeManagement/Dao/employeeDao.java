package com.Demo.EmployeeManagement.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Demo.EmployeeManagement.Model.Employee;

public interface employeeDao extends CrudRepository<Employee, Integer> {

	List<Employee> findByempName(String empName);

	

}
