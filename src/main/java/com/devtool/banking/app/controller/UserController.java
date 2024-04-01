package com.devtool.banking.app.controller;

import com.devtool.banking.app.dto.UserDto;
import com.devtool.banking.app.entity.User;
import com.devtool.banking.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@RequestBody User user){

        return new ResponseEntity<>(userService.createuser(user), HttpStatus.CREATED);

    }
}
