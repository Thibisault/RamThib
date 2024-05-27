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
import java.util.SortedSet;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    // Create
    public UserDto createUser(UserDto userDto) {
        System.out.println("Received UserDto in service: " + userDto);

        if (userDto.getEmail() == null || userDto.getFirstName() == null || userDto.getLastName() == null || userDto.getPassword() == null) {
            throw new IllegalArgumentException("All fields must be provided and not null");
        }
        System.out.println("user dto email: "+userDto.getEmail());
        System.out.println("user dto password: "+userDto.getPassword());
        System.out.println("user dto first name: "+userDto.getFirstName());
        System.out.println("user dto last name: "+userDto.getLastName());


        User user = new User();
        user.setEmail(userDto.getEmail());
        System.out.println("user email: "+user.getEmail());
        user.setFirstName(userDto.getFirstName());
        System.out.println("user first name: "+user.getFirstName());
        user.setLastName(userDto.getLastName());
        System.out.println("user last name: "+user.getLastName());
        user.setPassword(userDto.getPassword());
        System.out.println("user password: "+user.getPassword());


        //User user = userMapper.userDtoToUser(userDto);
        System.out.println("Mapped User from UserDto: " + user);

        User savedUser = userRepository.save(user);
        System.out.println("Saved User in DB: " + savedUser);

        UserDto savedUserDto = userMapper.userToUserDto(savedUser);
        System.out.println("Mapped Saved UserDto: " + savedUserDto);

        return savedUserDto;
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