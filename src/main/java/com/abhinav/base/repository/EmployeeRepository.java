package com.abhinav.base.repository;

import com.abhinav.base.dto.FNameLNameDTO;
import com.abhinav.base.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select firstName, lastName " +
            "from Employee " +
            "where salary > (select avg(salary) from Employee) " +
            "order by age,salary desc ")
//    Object[] findAllEmployeesByAverageSalary();
    List<FNameLNameDTO> findAllEmployeesByAverageSalary();
}