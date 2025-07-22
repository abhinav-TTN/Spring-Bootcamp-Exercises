package com.abhinav.base.controller;

import com.abhinav.base.model.Employee;
import com.abhinav.base.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    // Constructor to inject EmployeeService bean
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Returns list of all Employees at '/'
    @GetMapping("/")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployee();
    }

    // Returns one employee at '/id'
    @GetMapping("/{id}")
    public Employee getAllEmployees(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }

    // Appends an employee object to the List of employees in employee service
    @PostMapping("/")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    // Delete employee by id
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployeeById(id);
    }

    // Update Employee using id
    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }
}
