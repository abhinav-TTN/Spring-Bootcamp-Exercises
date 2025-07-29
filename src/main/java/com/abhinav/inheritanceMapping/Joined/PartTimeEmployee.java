package com.abhinav.inheritanceMapping.Joined;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PART_TIME")
public class PartTimeEmployee extends Employee {
    private int hourlyRate;

    public PartTimeEmployee() {
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}
