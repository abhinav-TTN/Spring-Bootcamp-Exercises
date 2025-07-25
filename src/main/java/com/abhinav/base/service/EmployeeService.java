package com.abhinav.base.service;

import com.abhinav.base.entity.Employee;
import com.abhinav.base.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    public Employee createOrUpdateEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }
}
