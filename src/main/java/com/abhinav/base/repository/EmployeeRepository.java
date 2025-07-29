package com.abhinav.base.repository;

import com.abhinav.base.dto.FNameLNameDto;
import com.abhinav.base.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("select avg(salary) from Employee")
    Double getAverageSalary();

    @Query("select firstName, lastName from Employee where salary > :avgSalary order by age, salary desc ")
    List<FNameLNameDto> findAllEmployeesByAverageSalary(@Param("avgSalary") Double avgSalary);

    @Modifying
    @Query("update Employee set salary= :newSalary where salary < :avgSalary")
    void updateEmployeeSalaryBelowAverageSalary(@Param("newSalary")Double newSalary, @Param("avgSalary") Double avgSalary);
}