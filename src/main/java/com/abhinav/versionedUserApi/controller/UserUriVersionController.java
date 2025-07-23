package com.abhinav.versionedUserApi.controller;

import com.abhinav.versionedUserApi.service.UserV1Service;
import com.abhinav.versionedUserApi.service.UserV2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserUriVersionController {

    private final UserV1Service userV1Service;
    private final UserV2Service userV2Service;

    public UserUriVersionController(UserV1Service userService, UserV2Service userV2Service) {
        this.userV1Service = userService;
        this.userV2Service = userV2Service;
    }

    // ---------------URI VERSIONING-------------------
    @GetMapping("/v1/users")
    public ResponseEntity<?> getAllUsersV1_uri() {
        return ResponseEntity.ok(userV1Service.getAllUsers());
    }

    @GetMapping("/v2/users")
    public ResponseEntity<?> getAllUsersV2_uri() {
        return ResponseEntity.ok(userV2Service.getAllUsers());
    }

    // ---------------PARAMS VERSIONING-------------------
    @GetMapping(value = "/users", params = {"version=1"})
    public ResponseEntity<?> getAllUsersV1_params() {
        return ResponseEntity.ok(userV1Service.getAllUsers());
    }

    @GetMapping(value = "/users", params = {"version=2"})
    public ResponseEntity<?> getAllUsersV2_params() {
        return ResponseEntity.ok(userV2Service.getAllUsers());
    }

    // ---------------HEADERS VERSIONING-------------------
    @GetMapping(value = "/users", headers = "X-API-VERSION=1")
    public ResponseEntity<?> getAllUsersV1_header() {
        return ResponseEntity.ok(userV1Service.getAllUsers());
    }

    @GetMapping(value = "/users", headers = "X-API-VERSION=2")
    public ResponseEntity<?> getAllUsersV2_header() {
        return ResponseEntity.ok(userV2Service.getAllUsers());
    }

    // ---------------HEADERS VERSIONING-------------------
    @GetMapping(value = "/users", produces = "application/com.abhinav.app-v1+json")
    public ResponseEntity<?> getAllUsersV1_mime() {
        return ResponseEntity.ok(userV1Service.getAllUsers());
    }

    @GetMapping(value = "/users", produces = "application/com.abhinav.app-v2+json")
    public ResponseEntity<?> getAllUsersV2_mime() {
        return ResponseEntity.ok(userV2Service.getAllUsers());
    }

}
