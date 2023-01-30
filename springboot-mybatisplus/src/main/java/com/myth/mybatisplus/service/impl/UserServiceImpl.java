package com.myth.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.myth.mybatisplus.entity.User;
import com.myth.mybatisplus.mapper.UserMapper;
import com.myth.mybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-01-30 14:18:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getList2() {
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<User> getList3() {
        return userMapper.selectList2();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }
}




