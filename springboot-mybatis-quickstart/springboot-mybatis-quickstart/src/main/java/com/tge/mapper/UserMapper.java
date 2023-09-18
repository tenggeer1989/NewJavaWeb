package com.tge.mapper;

import com.tge.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.tge.mapper
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/17 - 21:35
 * Version:
 */

@Mapper
public interface UserMapper {

    // 查询全部的用户信息
    @Select("select * from user")
    public List<User> list();
}
