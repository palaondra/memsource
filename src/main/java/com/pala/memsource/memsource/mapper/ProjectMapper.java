package com.pala.memsource.memsource.mapper;

import com.pala.memsource.memsource.client.domain.MemSourceProject;
import com.pala.memsource.memsource.dto.ProjectDto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {
    
    ProjectMapper INSTANCE = Mappers.getMapper( ProjectMapper.class ); 
    
    @Mapping(source = "name", target = "name")
    @Mapping(source = "sourceLang", target = "sourceLanguage")
    @Mapping(source = "targetLangs", target = "targetLanguageList")
    ProjectDto memSourceProjectToProjectDto(MemSourceProject memSourceProject);

}
