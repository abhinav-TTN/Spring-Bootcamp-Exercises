package com.abhinav.base.controller;

import com.abhinav.base.dto.FNameLNameDto;
import com.abhinav.base.dto.FNameLNameIdDto;
import com.abhinav.base.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<FNameLNameDto> getEmpAllBySalaryMoreThanAverage() {
        return employeeService.employeesGreaterThanAvgSalary();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateEmployeeSalary(@RequestBody Double newSalary) {
        employeeService.updateEmployeeSalaryWithSalaryBelowAverage(newSalary);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteEmployee() {
        employeeService.deleteEmployeeWithMinimumSalary();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/singh")
    public ResponseEntity<List<FNameLNameIdDto>> getEmployeesWithSurnameSingh() {
        return ResponseEntity.ok(employeeService.getEmployeesWithSurnameSingh());
    }

    @DeleteMapping("/age")
    public ResponseEntity<Void> deleteEmpOverAge(@RequestParam int age) {
        employeeService.deleteEmployeesOverAge(age);
        return ResponseEntity.ok().build();
    }

}
