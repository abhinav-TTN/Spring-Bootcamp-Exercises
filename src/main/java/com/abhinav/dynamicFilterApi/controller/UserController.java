package com.abhinav.dynamicFilterApi.controller;

import com.abhinav.dynamicFilterApi.dto.UserDto;
import com.abhinav.dynamicFilterApi.service.UserService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(description = "Handle User", name = "UserAPI")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    @Operation(summary = "Add a new User", description = "Provide the user id and name in the Request Body")
    public ResponseEntity<MappingJacksonValue> createUser(@RequestBody UserDto newUserDto) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userService.addUser(newUserDto));

        SimpleBeanPropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserDtoFilter",beanFilter);

        mappingJacksonValue.setFilters(filterProvider);
        return ResponseEntity.ok(mappingJacksonValue);
    }

    @GetMapping()
    @Operation(summary = "Get All Users", description = "Returns list of all users")
    public ResponseEntity<?> getAllUsers() {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userService.getAllUsers());

        SimpleBeanPropertyFilter beanFilter = SimpleBeanPropertyFilter.filterOutAllExcept("id","name");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("UserDtoFilter",beanFilter);

        mappingJacksonValue.setFilters(filterProvider);
        return ResponseEntity.ok(mappingJacksonValue);
    }

    @DeleteMapping()
    @Operation(summary = "Delete User", description = "Provide the id of the user to be deleted")
    public ResponseEntity<Boolean> deleteUser(Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
