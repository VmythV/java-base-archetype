package com.myth.mybatis.controller;

import com.myth.mybatis.entity.User;
import com.myth.mybatis.service.UserService;
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

    @GetMapping("/list2")
    Object getUser2() {
        return userService.getList2();
    }

    @PutMapping("/add")
    Object insertUser(@RequestBody User user) {
        userService.insert(user);
        return "OK,insert finish";
    }

    @PostMapping("/update/{id}")
    Object updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return "OK,update finish";
    }

    @PostMapping("/update2")
    Object updateUser2(@PathParam(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        userService.update(user);
        return "OK,update2 finish";
    }

    @PostMapping("/del")
    Object del(@PathParam(value = "id") Long id) {
        userService.delete(id);
        return "OK,del finish";
    }

}