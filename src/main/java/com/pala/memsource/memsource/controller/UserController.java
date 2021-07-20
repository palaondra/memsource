package com.pala.memsource.memsource.controller;

import com.pala.memsource.memsource.service.api.IUserService;

import javax.validation.Valid;

import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.exception.UsernameAlreadyExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class UserController {
    
    @Autowired
    private IUserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) throws UsernameAlreadyExistsException {
        return new ResponseEntity<UserDto>(
            userService.createUser(userDto), 
            HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") Long id) throws UserNotFoundException {
        return userService.getUser(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public UserDto updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) throws UserNotFoundException {
        return userService.updateUser(id, userDto);
    }

}
 