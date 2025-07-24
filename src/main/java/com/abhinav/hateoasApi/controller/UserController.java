package com.abhinav.hateoasApi.controller;

import com.abhinav.hateoasApi.dto.UserDto;
import com.abhinav.hateoasApi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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


    @GetMapping()
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public EntityModel<UserDto> getOneUser(@PathVariable int id) {
        WebMvcLinkBuilder linkToTopics = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserController.class).getAllUsers());

        return EntityModel.of(userService.getUserById(id))
                .add(linkToTopics.withRel("all-topics"));    }

}
