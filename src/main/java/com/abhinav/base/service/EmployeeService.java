package com.abhinav.base.service;

import com.abhinav.base.entity.Employee;
import com.abhinav.base.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    public List<Employee> readAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> readEmployeeBYId(Long id) {
        return employeeRepository
                .findById(id);
    }

    public Employee createOrUpdateEmployee(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    public long getEmployeeCount() {
        return employeeRepository.count();
    }
}
