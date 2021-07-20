package com.pala.memsource.memsource.service.api;

import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.exception.UsernameAlreadyExistsException;

public interface IUserService {

    UserDto createUser(UserDto userDto) throws UsernameAlreadyExistsException;

    UserDto updateUser(Long id, UserDto userDto) throws UserNotFoundException;

    void deleteUser(Long id)throws UserNotFoundException ;

    UserDto getUser(Long id) throws UserNotFoundException;

}