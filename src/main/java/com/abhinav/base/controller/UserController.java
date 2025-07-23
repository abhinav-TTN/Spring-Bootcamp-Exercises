package com.abhinav.base.controller;

import com.abhinav.base.dto.UserDto;
import com.abhinav.base.service.UserService;
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

    @Operation(summary = "Add a new User", description = "Provide the user id and name in the Request Body")
    @PostMapping()
    public ResponseEntity<Boolean> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }

    @Operation(summary = "Get All Users", description = "Returns list of all users")
    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Operation(summary = "Delete User", description = "Provide the id of the user to be deleted")
    @DeleteMapping()
    public ResponseEntity<Boolean> deleteUser(Integer id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
