package com.robertson.userManagement.controller;

import com.robertson.userManagement.model.User;
import com.robertson.userManagement.service.UserService;
import com.robertson.userManagement.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public void updateUser(@RequestBody @Valid User user) throws DuplicateException{
        userService.updateUser(user);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}


