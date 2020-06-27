package com.laikacode.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User POJO
 * POJO represent User entity extension of {@link Object} and implements {@link Serializable}
 * @author Francisco
 * @since 2020/06/27
 * */

@Data
@Entity
@Table(name = "user")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String lastname;

    @Column(unique = true)
    private String username;

    private String password;

    public User() {}

    public User(Integer id) {this.id = id;}

    public User(String name, String lastname, String username, String password) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String name, String lastname, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
    }
}
