package com.myth.mongo.service;

import com.myth.mongo.entity.User;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Service
* @createDate 2023-01-30 14:18:35
*/
public interface UserService{
    List<User> getList();

    void insert(User user);

    User getById(Long id);

    void deleteUser(Long id);
}
