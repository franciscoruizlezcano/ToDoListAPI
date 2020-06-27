package com.laikacode.todo.dto;

import com.laikacode.todo.domain.Task;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import org.modelmapper.ModelMapper;

/**
 * DTO Task
 * DTO represent {@link com.laikacode.todo.domain.Task} entity
 * @author Francisco
 * @since 2020/06/27
 * */

@Data
public class TaskDto {

    private Integer id;
    private String description;
    private Boolean complete;
    private UserDto user;

    public TaskDto() {}

    public TaskDto(Integer id) { this.id = id; }

    public TaskDto(String description, Boolean complete, UserDto user) {
        this.description = description;
        this.complete = complete;
        this.user = user;
    }

    public TaskDto(Integer id, String description, Boolean complete, UserDto user) {
        this.id = id;
        this.description = description;
        this.complete = complete;
        this.user = user;
    }

    public static TaskDto toDto(Task task) {
        ModelMapper modelMapper = new ModelMapper();
        TaskDto dto = modelMapper.map(task, TaskDto.class);
        return dto;
    }

    public static Task fromDto(TaskDto dto) {
        ModelMapper modelMapper = new ModelMapper();
        Task model = modelMapper.map(dto, Task.class);
        return model;
    }
}
