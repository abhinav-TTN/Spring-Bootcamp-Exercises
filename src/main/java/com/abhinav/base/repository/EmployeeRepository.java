package com.abhinav.base.repository;

import com.abhinav.base.dto.FNameLNameDto;
import com.abhinav.base.dto.FNameLNameIdDto;
import com.abhinav.base.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query("select avg(salary) from Employee")
    Double getAverageSalary();

    @Query("select min(salary) from Employee")
    Double getMinimumSalary();

    @Query("select firstName, lastName from Employee where salary > :avgSalary order by age, salary desc ")
    List<FNameLNameDto> findAllEmployeesByAverageSalary(@Param("avgSalary") Double avgSalary);

    @Modifying
    @Query("update Employee set salary= :newSalary where salary < :avgSalary")
    void updateEmployeeSalaryBelowAverageSalary(@Param("newSalary")Double newSalary, @Param("avgSalary") Double avgSalary);

    @Modifying
    @Query("delete from Employee where salary = :minSalary")
    void deleteEmployeeWithMinimumSalary(@Param("minSalary") Double minSalary);

    @NativeQuery("select empId,empFirstName,empLastName from employeeTable where empLastName like '%Singh'")
    List<FNameLNameIdDto> getEmployeesByLastNameEndingWithSingh();

    @Modifying
    @NativeQuery("delete from employeeTable where empAge > ?1")
//    @Query(value = "delete from employeeTable where empAge > :age", nativeQuery = true )
    void deleteEmployeesOverAge(int age);
}