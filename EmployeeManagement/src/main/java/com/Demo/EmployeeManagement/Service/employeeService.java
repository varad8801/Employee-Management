package com.Demo.EmployeeManagement.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Demo.EmployeeManagement.Dao.employeeDao;
import com.Demo.EmployeeManagement.Model.Employee;

@Service
public class employeeService {
    @Autowired
    employeeDao employeedao;

    public List<Employee> allEmployees() {
        try {
            return (List<Employee>) employeedao.findAll();
        } catch (Exception e) {
            // Handle the exception, log it, and possibly provide a user-friendly error message
            e.printStackTrace();
            return new ArrayList<>(); // Return an empty list or handle the error accordingly
        }
    }

    public Optional<Employee> getempById(int empId) {
        try {
            return employeedao.findById(empId);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // Return an empty Optional or handle the error accordingly
        }
    }

    public String addEmployee(List<Employee> employee) {
        try {
            employeedao.saveAll(employee);
            return "Added " + employee.size() + " employees";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding employees"; // Handle the error accordingly
        }
    }

    public String updateEmployees(List<Employee> employees) {
        try {
            employeedao.saveAll(employees);
            return "Updated " + employees.size() + " employees";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error updating employees"; // Handle the error accordingly
        }
    }

    public String deleteEmployees(List<String> empName) {
        try {
            for (String i : empName) {
                employeedao.deleteAll(employeedao.findByempName(i));
            }
            return "Deleted " + empName;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting employees"; // Handle the error accordingly
        }
    }
}
