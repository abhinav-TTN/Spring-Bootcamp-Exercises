package com.abhinav.base.controller;

import com.abhinav.base.model.Employee;
import com.abhinav.base.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Returns all employee at '/' and one employee at '/id'
    @GetMapping({"/","/{id}"})
    public List<Employee> getAllEmployees(@PathVariable(required = false) Integer id) {
        if(id==null)
            return employeeService.getAllEmployee();
        return List.of(employeeService.getEmployeeById(id));
    }
}
