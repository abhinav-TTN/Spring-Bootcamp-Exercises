package com.abhinav.inheritanceMapping.Table_per_Class;

import jakarta.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
    private int hourlyRate;

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
