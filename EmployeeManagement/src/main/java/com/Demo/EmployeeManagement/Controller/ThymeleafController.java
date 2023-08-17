package com.Demo.EmployeeManagement.Controller;

import com.Demo.EmployeeManagement.Service.employeeService;
import com.Demo.EmployeeManagement.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @Autowired
    private employeeService empService;

    @GetMapping("/employee")
    public String showEmployees(Model model) {
        model.addAttribute("employees", empService.allEmployees());
        return "employee";
    }
}
