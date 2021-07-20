package com.pala.memsource.memsource.dto;

import java.util.List;

/**
 * Project Data Transfer object.
 */
public class ProjectDto {
    
    private String name; 
    
    private String sourceLanguage; 
    
    private List<String> targetLanguageList;

    public ProjectDto() {}

    public ProjectDto(String name, String sourceLanguage, List<String> targetLanguageList) {
        this.name = name;
        this.sourceLanguage = sourceLanguage;
        this.targetLanguageList = targetLanguageList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public List<String> getTargetLanguageList() {
        return targetLanguageList;
    }

    public void setTargetLanguageList(List<String> targetLanguageList) {
        this.targetLanguageList = targetLanguageList;
    }

    

}
