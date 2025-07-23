package com.abhinav.staticFilterApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record UserDto(
        Integer id,
        String name,
        @JsonIgnore
        String password
) {}
