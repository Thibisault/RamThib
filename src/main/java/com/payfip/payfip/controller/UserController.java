//path: src/main/java/com/payfip/payfip/service/FactureService.java
package com.payfip.payfip.controller;

import com.payfip.payfip.dto.UserDto;
import com.payfip.payfip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserDto createUser(@RequestBody Map<String, String> data) {
        System.out.println("Je suis dans le controller createUser : "+data );
        UserDto userDto = new UserDto();
        userDto.setEmail(data.get("email"));
        userDto.setPassword(data.get("password"));
        userDto.setFirstName(data.get("firstName"));
        userDto.setLastName(data.get("lastName"));
        UserDto createdUserDto = userService.createUser(userDto);
        return createdUserDto;
    }
    /*
        // Create
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {

        System.out.println("Je suis dans le controller user createUser");
        System.out.println("Je suis dans le controller user createUser : "+userDto );
        UserDto createdUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(createdUserDto);
    }
     */

    // Read
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        System.out.println("Je suis dans le controller user getAllUsers");
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        UserDto updatedUserDto = userService.updateUser(userDto);
        return ResponseEntity.ok(updatedUserDto);
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        System.out.println("Je suis dans le controller user deleteUser");
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}