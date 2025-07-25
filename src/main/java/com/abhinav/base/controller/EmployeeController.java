package com.abhinav.base.controller;

import com.abhinav.base.entity.Employee;
import com.abhinav.base.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee, UriComponentsBuilder uriComponentsBuilder) {
        Employee savedEmployee = employeeService.createOrUpdateEmployee(employee);

        URI newResourceUri = uriComponentsBuilder
                .path("/employees/{id}")
                .buildAndExpand(savedEmployee.getId())
                .toUri();

        return ResponseEntity.created(newResourceUri).build();
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteEmployeeByEntity(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
        return ResponseEntity.noContent().build();
    }
}
