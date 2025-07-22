package com.abhinav.base.service;

import com.abhinav.base.exception.ResourceNotFoundException;
import com.abhinav.base.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private final List<EmployeeDto> employeeDtoList = new ArrayList<>();

    EmployeeService() {
        employeeDtoList.add(new EmployeeDto(1, "Abhinav", 21));
        employeeDtoList.add(new EmployeeDto(2, "Deepanshu", 21));
        employeeDtoList.add(new EmployeeDto(3, "Animesh", 21));
    }

    public List<EmployeeDto> getAllEmployee() {
        return employeeDtoList;
    }

    public EmployeeDto getEmployeeById(int id) {
        return employeeDtoList.stream()
                .filter(employeeDto -> employeeDto.id() == id)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("id=" + id));
    }

    public boolean addEmployee(EmployeeDto newEmployeeDto) {
        return employeeDtoList.add(newEmployeeDto);
    }

    public boolean deleteEmployeeById(int id) {
        EmployeeDto employeeDTO = this.getEmployeeById(id);
        return employeeDtoList.remove(employeeDTO);
    }

    public EmployeeDto updateEmployee(EmployeeDto updatedEmployeeDto) {
        // Check if employee exists
        EmployeeDto employeeDTO = getEmployeeById(updatedEmployeeDto.id());

        // Find index of employee in employeeList
        int index = employeeDtoList.indexOf(employeeDTO);
        employeeDtoList.set(index, updatedEmployeeDto);
        return employeeDtoList.get(index);
    }
}
