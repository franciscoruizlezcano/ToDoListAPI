package com.laikacode.todo.resource;

import com.laikacode.todo.domain.User;
import com.laikacode.todo.dto.UserDto;
import com.laikacode.todo.resource.util.CrudResource;
import com.laikacode.todo.service.UserService;
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
 * Represent services web for {@link User} entity
 * @author Francisco
 */

@RestController
@Api(tags = "user")
@RequestMapping("/api/user")
public class UserResource implements CrudResource<UserDto, Integer> {

    @Autowired
    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @Override
    @GetMapping
    @ApiOperation(value = "Find all users", notes = "Service of find all users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<List<UserDto>> findAll() {

        List<UserDto> response = new ArrayList<>();
        List<User> userList = this.service.findAll();

        for (User user : userList){
            response.add(UserDto.toDto(user));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Find user by Id", notes = "Service of find user by id ")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<UserDto> findById(@PathVariable Integer id) {
        UserDto response = UserDto.toDto(this.service.findById(id).orElse(null));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @PostMapping
    @ApiOperation(value = "Save user", notes = "Service of save user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<UserDto> save(@RequestBody UserDto dto) {
        User user = UserDto.fromDto(dto);
        dto = UserDto.toDto(this.service.save(user));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    @PutMapping
    @ApiOperation(value = "Find and update user", notes = "Service of update user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<UserDto> update(@PathVariable Integer id, @RequestBody UserDto dto) {
        User user = this.service.findById(id).orElse(null);

        user.setName(dto.getName());
        user.setLastname(dto.getLastname());
        user.setUsername(dto.getUsername());

        dto = UserDto.toDto(this.service.save(user));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Find and delete user by id", notes = "Service of delete user by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> delete(@PathVariable Integer id) {
        HashMap<String, Boolean> response = new HashMap<>();

        User user = this.service.findById(id).orElse(null);

        this.service.delete(user);
        response.put("message: ", true);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
