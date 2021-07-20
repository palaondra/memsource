package com.pala.memsource.memsource.service.api;

import java.util.List;

import com.pala.memsource.memsource.dto.ProjectDto;
import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;

public interface IProjectService {
    
    List<ProjectDto> getProjectList(UserDto userDto) throws UserNotFoundException;

}
