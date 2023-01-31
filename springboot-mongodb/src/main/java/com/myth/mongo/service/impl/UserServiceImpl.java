package com.myth.mongo.service.impl;

import com.myth.mongo.entity.User;
import com.myth.mongo.repository.UserRepository;
import com.myth.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-01-30 14:18:35
*/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public void insert(User user) {
        userRepository.insert(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}




