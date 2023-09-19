package com.Demo.EmployeeManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Demo.EmployeeManagement.Model.Employee;
import com.Demo.EmployeeManagement.Service.employeeService;

@RestController
@RequestMapping("admin")
public class adminController {
	@Autowired
	employeeService empser;
	
	
	
	@GetMapping("allEmployees")
	@ResponseBody
	public List<Employee> allEmployees(){
		
		return empser.allEmployees();
	}
	@GetMapping("getempById")
	@ResponseBody
	public Optional<Employee> getempById(@RequestParam int empId){
		return empser.getempById(empId);
	}
	@GetMapping("getempByName")
	@ResponseBody
	public List<Employee> getempByName(@RequestParam List<String> empName){
		return empser.getempByName(empName);
	}
	
	@PostMapping("add")
	public String addEmployee(@RequestBody List<Employee> employees) {
		return empser.addEmployee(employees);
	}  
	
	@PutMapping("update")
	public String updateEmployees(@RequestBody List<Employee> employees) {
		return empser.updateEmployees(employees);
	}
	
	@DeleteMapping("delete")
	public String deleteEmployees(@RequestParam List<String>empName) {
		return empser.deleteEmployees(empName);
	}
	
	
}
