package com.laikacode.todo.dto;

import lombok.Data;

@Data
public class AuthDto {
    private String username;
    private String password;

    public AuthDto() {}

    public AuthDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
