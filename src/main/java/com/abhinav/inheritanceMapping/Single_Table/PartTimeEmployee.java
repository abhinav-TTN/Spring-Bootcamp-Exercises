package com.abhinav.inheritanceMapping.Single_Table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PART_TIME")
public class PartTimeEmployee extends Employee {
    private int hourlyRate;
}
