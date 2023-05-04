package com.alon.jobApplicationsManager.controllers;

import com.alon.jobApplicationsManager.beans.User;
import com.alon.jobApplicationsManager.exceptions.JobAppException;
import com.alon.jobApplicationsManager.responses.UserResponse;
import com.alon.jobApplicationsManager.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse addUser(User user) throws JobAppException {
        return service.addUser(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getOneUser(@PathVariable String id) throws JobAppException {
        return service.getOneUser(id);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@RequestBody User user) throws JobAppException {
        return service.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable String id) throws JobAppException {
        service.deleteUser(id);
    }

}
