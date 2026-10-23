package com.devtracker.devtracker_backend.controller;

import com.devtracker.devtracker_backend.dto.UserRequest;
import com.devtracker.devtracker_backend.entity.User;
import com.devtracker.devtracker_backend.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {

        return ResponseEntity.ok(
                userService.getAllUsers()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                userService.getUserById(id)
        );
    }

    @PostMapping
    public ResponseEntity<User> createUser(
            @Valid @RequestBody UserRequest request) {

        return ResponseEntity.ok(
                userService.createUser(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request) {

        return ResponseEntity.ok(
                userService.updateUser(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}