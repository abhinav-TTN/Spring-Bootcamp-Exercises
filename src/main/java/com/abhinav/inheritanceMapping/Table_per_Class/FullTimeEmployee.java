package com.abhinav.inheritanceMapping.Table_per_Class;

import jakarta.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

