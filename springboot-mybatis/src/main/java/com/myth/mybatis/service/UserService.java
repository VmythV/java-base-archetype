package com.myth.mybatis.service;

import com.myth.mybatis.entity.User;

import java.util.List;

/**
 * The interface User service.
 *
 * @author may
 * @description 针对表 【user】的数据库操作Service
 * @createDate 2023 -01-29 15:23:58
 */
public interface UserService {
    /**
     * Gets list.
     *
     * @return the list
     */
    List<User> getList();

    /**
     * Gets list 2.
     *
     * @return the list 2
     */
    List<User> getList2();

    /**
     * Insert.
     *
     * @param user the user
     */
    void insert(User user);

    /**
     * Update.
     *
     * @param user the user
     */
    void update(User user);

    /**
     * Delete.
     *
     * @param id the id
     */
    void delete(Long id);
}
