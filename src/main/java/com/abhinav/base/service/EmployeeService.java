package com.abhinav.base.service;

import com.abhinav.base.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    EmployeeService() {

    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        for(Employee employee:employeeList) {
            if(employee.id()==id) return employee;
        }
        return null;
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }

    public void deleteEmployeeById(Employee employee) {
        employeeList.remove(employee);
    }
}
