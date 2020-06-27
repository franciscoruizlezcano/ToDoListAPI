package com.laikacode.todo.resource;

import com.laikacode.todo.domain.Task;
import com.laikacode.todo.domain.User;
import com.laikacode.todo.dto.TaskDto;
import com.laikacode.todo.resource.util.CrudResource;
import com.laikacode.todo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represent services web for {@link Task} entity
 * @author Francisco
 */

@RestController
@Api(tags = "task")
@RequestMapping("/api/task")
public class TaskResource implements CrudResource<TaskDto, Integer> {

    @Autowired
    private final TaskService service;

    public TaskResource(TaskService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Find all tasks", notes = "Service of find all tasks")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<List<TaskDto>> findAll() {
        List<TaskDto> response =  new ArrayList<>();
        List<Task> taskList = this.service.findAll();

        for (Task task : taskList){
            response.add(TaskDto.toDto(task));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Find tasks by Id", notes = "Service of find tasks by id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<TaskDto> findById(@PathVariable Integer id) {
        TaskDto response = TaskDto.toDto(this.service.findById(id).orElse(null));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Save task", notes = "Service of save task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<TaskDto> save(@RequestBody TaskDto dto) {
        Task task = TaskDto.fromDto(dto);
        dto = TaskDto.toDto(this.service.save(task));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Find and update task", notes = "Service of update task")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<TaskDto> update(@PathVariable Integer id, @RequestBody TaskDto dto) {
        Task task = this.service.findById(id).orElse(null);

        task.setDescription(dto.getDescription());
        task.setComplete(dto.getComplete());

        dto = TaskDto.toDto(this.service.save(task));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Find and delete task by id", notes = "Service of delete task by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> delete(@PathVariable Integer id) {
        HashMap<String, Boolean> response = new HashMap<>();

        Task task = this.service.findById(id).orElse(null);
        this.service.delete(task);

        response.put("message: ", true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
