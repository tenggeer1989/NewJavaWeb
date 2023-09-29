package com.tge.mapper;

import com.tge.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * ClassName: LoginMapper
 * Package: com.tge.mapper
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/25 - 16:18
 * Version:
 */
@Mapper
public interface LoginMapper {

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp login(Emp emp);

}
