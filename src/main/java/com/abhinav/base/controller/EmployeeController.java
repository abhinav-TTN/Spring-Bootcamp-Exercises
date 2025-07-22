package com.abhinav.base.controller;

import com.abhinav.base.model.Employee;
import com.abhinav.base.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }
}
