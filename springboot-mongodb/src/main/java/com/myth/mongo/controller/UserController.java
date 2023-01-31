package com.myth.mongo.controller;

import com.myth.mongo.entity.User;
import com.myth.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RequestMapping("/api/v1")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/list")
    Object getUser() {
        return userService.getList();
    }

    @GetMapping("/query/{id}")
    Object getUser2(@PathVariable(value = "id") Long id) {
        return userService.getById(id);
    }

    @PutMapping("/add")
    Object insertUser(@RequestBody User user) {
        userService.insert(user);
        return "OK,insert finish";
    }

    @PostMapping("/del")
    Object del(@PathParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "OK,del finish";
    }

}