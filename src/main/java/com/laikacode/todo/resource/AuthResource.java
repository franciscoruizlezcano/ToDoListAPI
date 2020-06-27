package com.laikacode.todo.resource;

import com.laikacode.todo.domain.User;
import com.laikacode.todo.dto.AuthDto;
import com.laikacode.todo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Represent services web for authentication of {@link User} entity
 * @author Francisco
 */

@RestController
@Api(tags = "auth")
@RequestMapping("/api/auth")
public class AuthResource {

    @Autowired
    private final UserService service;

    public AuthResource(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ApiOperation(value = "Authentication", notes = "Service of find user by username and compare passwords")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Request valid"),
            @ApiResponse(code = 400, message = "Request invalid")
    })
    public ResponseEntity<HashMap<String, Boolean>> login(@RequestBody AuthDto authDto) {
        HashMap<String, Boolean> response = new HashMap<>();
        response.put("message", this.service.login(authDto.getUsername(), authDto.getPassword()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
