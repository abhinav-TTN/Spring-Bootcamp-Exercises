package com.abhinav.question1To3Answers.controller;

import com.abhinav.question1To3Answers.dto.UserDto;
import com.abhinav.question1To3Answers.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Boolean> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @GetMapping()
    @Operation(summary = "Get All Users", description = "Returns list of all users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @DeleteMapping()
    @Operation(summary = "Delete User", description = "Provide the id of the user to be deleted")
    public ResponseEntity<Boolean> deleteUser(Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
