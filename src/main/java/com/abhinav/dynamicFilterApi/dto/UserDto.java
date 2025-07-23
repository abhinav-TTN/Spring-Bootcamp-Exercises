package com.abhinav.dynamicFilterApi.dto;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("UserDtoFilter")
public record UserDto(
        Integer id,
        String name,
        String password
) {}
