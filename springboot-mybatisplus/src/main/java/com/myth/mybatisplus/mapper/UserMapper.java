package com.myth.mybatisplus.mapper;

import com.myth.mybatisplus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author may
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-01-30 14:18:35
* @Entity com.myth.mybatisplus.entity.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectList2();
}




