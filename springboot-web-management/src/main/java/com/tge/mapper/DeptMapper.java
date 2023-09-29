package com.tge.mapper;

import com.tge.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * ClassName: DeptMapper
 * Package: com.tge.mapper
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:48
 * Version:
 */
@Mapper
public interface DeptMapper{

    /**
     * 查询全部部门
     * @return
     */
    @Select("select * from dept")
    List<Dept> list();


    /**
     * 按照ID删除部门
     * @param id
     */
    @Delete("delete from dept where id = #{id}")
    void deleteDept(Integer id);

    /**
     * 新增部门
     */
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    void addDeptByName(Dept dept);


}
