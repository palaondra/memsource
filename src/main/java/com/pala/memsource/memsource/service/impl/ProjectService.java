package com.pala.memsource.memsource.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pala.memsource.memsource.auth.MemSourceAuthManager;
import com.pala.memsource.memsource.client.MemSourceRestClient;
import com.pala.memsource.memsource.client.domain.MemSourceListOfProjectResponse;
import com.pala.memsource.memsource.dto.ProjectDto;
import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.exception.UsernameAlreadyExistsException;
import com.pala.memsource.memsource.mapper.ProjectMapper;
import com.pala.memsource.memsource.repository.UserRepository;
import com.pala.memsource.memsource.repository.domain.User;
import com.pala.memsource.memsource.service.api.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

@Service
public class ProjectService implements IProjectService {
    
    @Autowired
    private MemSourceRestClient memSourceRestClient;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<ProjectDto> getProjectList(UserDto userDto) throws UserNotFoundException {
        // check if exists user with incoming username
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(userDto.getUsername()));
        if (!userOptional.isPresent()) {
            throw new UserNotFoundException("User with username: " + userDto.getUsername() + " not found");
        }
        
        MemSourceListOfProjectResponse response = memSourceRestClient.getMemsourceProjectList(userDto.getUsername(), userDto.getPassword());
        
        if (!ObjectUtils.isEmpty(response) && !CollectionUtils.isEmpty(response.getContent())) {
            return response.getContent().stream()
                .map(p -> ProjectMapper.INSTANCE.memSourceProjectToProjectDto(p))
                .collect(Collectors.toList());
        }
        
        return null;
    }
    
}
