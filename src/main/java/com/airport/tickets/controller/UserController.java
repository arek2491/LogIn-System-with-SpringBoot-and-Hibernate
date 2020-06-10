package com.airport.tickets.controller;

import com.airport.tickets.domain.UserDto;
import com.airport.tickets.domain.UserNotFoundException;
import com.airport.tickets.mapper.UserMapper;
import com.airport.tickets.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserDbService service;

    @Autowired
    private UserMapper mapper;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Set<UserDto> getUsers() {
        return mapper.mapToUserDtoList(service.getAllUsers());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        return mapper.mapToUserDto(service.getUserById(userId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        service.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        service.saveUser(mapper.mapToUser(userDto));
    }

}
