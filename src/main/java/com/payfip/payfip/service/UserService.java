//path: src/main/java/com/payfip/payfip/service/UserService.java
package com.payfip.payfip.service;

import com.payfip.payfip.dto.UserDto;
import com.payfip.payfip.dto.UserMapper;
import com.payfip.payfip.models.User;
import com.payfip.payfip.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    // Create
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }

    // Read
    public Optional<UserDto> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(userMapper::userToUserDto);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::userToUserDto).collect(Collectors.toList());
    }

    // Read by first name
    public Optional<UserDto> getUserByFirstName(String firstName) {
        Optional<User> user = userRepository.findByFirstName(firstName);
        return user.map(userMapper::userToUserDto);
    }

    // Read by email
    public Optional<UserDto> getUserByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(userMapper::userToUserDto);
    }

    // Update
    public UserDto updateUser(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        User updatedUser = userRepository.save(user);
        return userMapper.userToUserDto(updatedUser);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
