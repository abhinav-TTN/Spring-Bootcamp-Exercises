package com.abhinav.base.service;

import com.abhinav.base.entity.Employee;
import com.abhinav.base.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    public Page<Employee> readAllEmployees(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page,size, Sort.by("age").ascending()));
    }

    public Optional<Employee> readEmployeeBYId(Long id) {
        return employeeRepository
                .findById(id);
    }

    public List<Employee> readAllEmployeesByName(String name) {
        return employeeRepository.findAllByName(name);
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
