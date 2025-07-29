package com.abhinav.base.controller;

import com.abhinav.base.dto.FNameLNameDTO;
import com.abhinav.base.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

//    @GetMapping("")
//    public ResponseEntity<Object[]> getEmpAllBySalary() {
//        return ResponseEntity.ok(employeeService.employeesGreaterThanAvgSalary());
//    }

    @GetMapping("")
    public List<FNameLNameDTO> getEmpAllBySalaryNoEntity() {
        return employeeService.employeesGreaterThanAvgSalary();
    }
}
