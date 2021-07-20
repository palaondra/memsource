package com.pala.memsource.memsource.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

/**
 * User Data Transfer Object.
 */
public class UserDto {
    
    private Long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public UserDto() {}

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
