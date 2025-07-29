package com.abhinav.base.service;

import com.abhinav.base.dto.FNameLNameDTO;
import com.abhinav.base.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<FNameLNameDTO> employeesGreaterThanAvgSalary() {
        return employeeRepository.findAllEmployeesByAverageSalary();
    }
}
