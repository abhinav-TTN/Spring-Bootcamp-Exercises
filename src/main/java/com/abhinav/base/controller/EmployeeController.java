package com.abhinav.base.controller;

import com.abhinav.base.entity.Employee;
import com.abhinav.base.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0", required = false) int page,
                                                          @RequestParam(defaultValue = "2", required = false) int size) {
        return ResponseEntity.ok(employeeService.readAllEmployees(page, size).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return employeeService.readEmployeeBYId(id)
                .map(employee -> ResponseEntity.ok(employee))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
        List<Employee> employees = employeeService.readAllEmployeesByName(name);

        return employees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(employees);
    }

    @GetMapping("/search/A")
    public ResponseEntity<List<Employee>> getAllEmployeesByNameA() {
        List<Employee> employees = employeeService.readEmployeesByA();

        return employees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(employees);
    }

    @GetMapping("/search/age")
    public ResponseEntity<List<Employee>> getEmployeesBetween28And32() {
        List<Employee> employees = employeeService.readEmployeesBetweenAge();

        return employees.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(employees);
    }

    @PostMapping("")
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

    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount() {
        return ResponseEntity.ok(employeeService.getEmployeeCount());
    }
}
