package com.myth.mybatisplus.service;

import com.myth.mybatisplus.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Service
* @createDate 2023-01-30 14:18:35
*/
public interface UserService extends IService<User> {

    List<User> getList2();

    List<User> getList3();

    void updateUser(User user);
}
