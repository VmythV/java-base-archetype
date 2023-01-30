package com.myth.mybatisplus.controller;

import com.myth.mybatisplus.entity.User;
import com.myth.mybatisplus.service.UserService;
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
        return userService.list();
    }

    @GetMapping("/list2")
    Object getUser2() {
        return userService.getList2();
    }

    @GetMapping("/list3")
    Object getUser3() {
        return userService.getList3();
    }

    @PutMapping("/add")
    Object insertUser(@RequestBody User user) {
        userService.save(user);
        return "OK,insert finish";
    }

    @PostMapping("/update/{id}")
    Object updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateById(user);
        return "OK,update finish";
    }

    @PostMapping("/update2")
    Object updateUser2(@PathParam(value = "id") Long id, @RequestBody User user) {
        user.setId(id);
        userService.updateUser(user);
        return "OK,update2 finish";
    }

    @PostMapping("/del")
    Object del(@PathParam(value = "id") Long id) {
        userService.removeById(id);
        return "OK,del finish";
    }

}