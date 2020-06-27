package com.laikacode.todo.dto;

import com.laikacode.todo.domain.Task;
import com.laikacode.todo.domain.User;
import lombok.Data;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

/**
 * DTO User
 * DTO represent {@link com.laikacode.todo.domain.User} entity
 * @author Francisco
 * @since 2020/06/27
 * */

@Data
public class UserDto {

    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String password;

    public UserDto() {}

    public UserDto(Integer id) {this.id = id;}

    public UserDto(String name, String lastname, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public UserDto(Integer id, String name, String lastname, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public static UserDto toDto(User user) {
        ModelMapper modelMapper = new ModelMapper();
        UserDto dto = modelMapper.map(user, UserDto.class);
        return dto;
    }

    public static User fromDto(UserDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        User model = modelMapper.map(dto, User.class);
        return model;
    }
}
