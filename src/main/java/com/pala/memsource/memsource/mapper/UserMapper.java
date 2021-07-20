package com.pala.memsource.memsource.mapper;

import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.repository.domain.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class ); 
    
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

}
