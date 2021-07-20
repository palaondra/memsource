package com.pala.memsource.memsource.service.impl;

import java.util.Optional;

import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.exception.UsernameAlreadyExistsException;
import com.pala.memsource.memsource.mapper.UserMapper;
import com.pala.memsource.memsource.repository.UserRepository;
import com.pala.memsource.memsource.service.api.IUserService;
import com.pala.memsource.memsource.repository.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) throws UsernameAlreadyExistsException {
        // check if exists user with incoming username
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(userDto.getUsername()));
        if (userOptional.isPresent()) {
            throw new UsernameAlreadyExistsException("User with username: " + userDto.getUsername() + " already exists");
        }
        
        // map incoming UserDto to User entity
        User newUser = UserMapper.INSTANCE.userDtoToUser(userDto);
        
        // save User entity
        User savedUser = userRepository.save(newUser);

        return UserMapper.INSTANCE.userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) throws UserNotFoundException {
        // check if user with incoming ID exists
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with ID: " + id + " not found");
        }

        // update user
        User updatingUser = UserMapper.INSTANCE.userDtoToUser(userDto);
        updatingUser.setId(userOptional.get().getId());

        User updatedUser = userRepository.save(updatingUser);

        return UserMapper.INSTANCE.userToUserDto(updatedUser);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        // check if user with incoming ID exists
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with ID: " + id + " not found");
        }
    
        // delete user
        userRepository.delete(userOptional.get());  
    }

    @Override
    public UserDto getUser(Long id) throws UserNotFoundException {
        // checl if user with incoming ID exists
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with ID: " + id + " not found");
        }

        return UserMapper.INSTANCE.userToUserDto(userOptional.get());
    }
    
}
