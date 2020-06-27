package com.laikacode.todo.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Task POJO
 * POJO represent Task entity extension of {@link Object} and implements {@link Serializable}
 * @author Francisco
 * @since 2020/06/27
 * */

@Data
@Entity
@Table(name = "task")
public class Task{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    private Boolean complete;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    public Task() {}

    public Task(Integer id) { this.id = id; }

    public Task(String description, Boolean complete, User user) {
        this.description = description;
        this.complete = complete;
        this.user = user;
    }

    public Task(Integer id, String description, Boolean complete, User user) {
        this.id = id;
        this.description = description;
        this.complete = complete;
        this.user = user;
    }
}
