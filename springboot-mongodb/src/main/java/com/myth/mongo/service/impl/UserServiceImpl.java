package com.myth.mongo.service.impl;

import com.myth.mongo.entity.User;
import com.myth.mongo.repository.UserRepository;
import com.myth.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        // 条件查询
        //User user = new User();
        //user.setId(id);
        //Example<User> userExample = Example.of(user);
        //Optional<User> oneUser = userRepository.findOne(userExample);
        //User user = userRepository.findUserById(id);
        //return oneUser.orElseGet(User::new);

        // 模糊查询
        //创建匹配器，即如何使用查询条件
        ExampleMatcher matcher = ExampleMatcher.matching() //构建对象
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) //改变默认字符串匹配方式：模糊查询
                .withIgnoreCase(true); //改变默认大小写忽略方式：忽略大小写
        User user = new User();
        user.setName("san");
        Example<User> userExample = Example.of(user, matcher);
        Optional<User> oneUser = userRepository.findOne(userExample);
        return oneUser.orElse(new User());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}




