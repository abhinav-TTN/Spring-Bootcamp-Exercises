package com.abhinav.base.service;

import com.abhinav.base.exception.ResourceNotFoundException;
import com.abhinav.base.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<Employee> employeeList = new ArrayList<>();

    EmployeeService() {
        employeeList.add(new Employee(1, "Abhinav", 21));
        employeeList.add(new Employee(2, "Deepanshu", 21));
        employeeList.add(new Employee(3, "Animesh", 21));
    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        return employeeList.stream()
                .filter(employee -> employee.id() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("id=" + id));
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }

    public void deleteEmployeeById(int id) {
        Employee employee = this.getEmployeeById(id);
        employeeList.remove(employee);
    }
}
