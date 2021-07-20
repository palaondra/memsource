package com.pala.memsource.memsource.controller;

import java.util.List;

import com.pala.memsource.memsource.dto.ProjectDto;
import com.pala.memsource.memsource.dto.UserDto;
import com.pala.memsource.memsource.exception.UserNotFoundException;
import com.pala.memsource.memsource.service.api.IProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    
    @Autowired
    private IProjectService projectService;

    @PostMapping("/projects")
    public List<ProjectDto> getProjects(@RequestBody UserDto userDto) throws UserNotFoundException {
        return projectService.getProjectList(userDto);
    }

}
