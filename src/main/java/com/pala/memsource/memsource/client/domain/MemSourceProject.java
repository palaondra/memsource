package com.pala.memsource.memsource.client.domain;

import java.util.List;

public class MemSourceProject {
    
    private String name;
    
    private String sourceLang; 
    
    private List<String> targetLangs;

    public MemSourceProject() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(String sourceLang) {
        this.sourceLang = sourceLang;
    }

    public List<String> getTargetLangs() {
        return targetLangs;
    }

    public void setTargetLangs(List<String> targetLangs) {
        this.targetLangs = targetLangs;
    }

    

}
