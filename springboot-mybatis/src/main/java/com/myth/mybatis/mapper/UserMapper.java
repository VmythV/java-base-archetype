package com.myth.mybatis.mapper;

import com.myth.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * The interface User mapper.
 *
 * @author may
 * @description 针对表 【user】的数据库操作Mapper
 * @createDate 2023 -01-29 15:23:58
 * @Entity com.myth.mybatis.entity.User
 */
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> getList();

    List<User> getList2();

    void insert(User user);

    void update(User user);

    void delete(Long id);
}




