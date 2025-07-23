package com.abhinav.base.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDto(
        Integer id,
        String name,
        @JsonIgnore
        String password
) {}
