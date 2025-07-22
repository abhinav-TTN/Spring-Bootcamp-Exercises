package com.abhinav.base.controller;

import com.abhinav.base.dto.UserDto;
import com.abhinav.base.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public Boolean createUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
