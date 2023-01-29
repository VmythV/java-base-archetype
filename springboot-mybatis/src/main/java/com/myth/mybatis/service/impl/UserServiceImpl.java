package com.myth.mybatis.service.impl;

import com.myth.mybatis.entity.User;
import com.myth.mybatis.mapper.UserMapper;
import com.myth.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-01-29 15:23:58
*/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getList() {
        return userMapper.getList();
    }

    @Override
    public List<User> getList2() {
        return userMapper.getList2();
    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}




