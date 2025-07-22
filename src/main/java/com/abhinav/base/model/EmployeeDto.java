package com.abhinav.base.model;

import jakarta.validation.constraints.*;

public record EmployeeDto(
        int id,

        @Size(min = 3, max=10, message = "Name should be between 3 and 10 characters.")
        String name,

        @Min(value=18, message = "Age too low")
        int age
) {}
