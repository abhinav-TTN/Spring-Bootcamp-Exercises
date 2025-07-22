package com.abhinav.base.controller;

import com.abhinav.base.model.EmployeeDto;
import com.abhinav.base.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/employees")
public class EmployeeController {

    final EmployeeService employeeService;

    // Constructor to inject EmployeeService bean
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Returns one employee at '/id'
    @GetMapping()
    public ResponseEntity<?> getAllEmployees(@RequestParam(required = false) Integer id) {
        if(id == null)
            return ResponseEntity.ok(employeeService.getAllEmployee());
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // Appends an employee object to the List of employees in employee service
    @PostMapping()
    public ResponseEntity<Boolean> createEmployee(@Valid @RequestBody EmployeeDto employeeDTO) {
        return ResponseEntity.ok(employeeService.addEmployee(employeeDTO));
    }

    // Delete employee by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
    }

    // Update Employee using Request body
    @PutMapping()
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDTO) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDTO));
    }
}
