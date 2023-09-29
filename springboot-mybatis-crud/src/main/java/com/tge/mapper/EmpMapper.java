package com.tge.mapper;

import com.tge.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.tge.mapper
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/18 - 22:11
 * Version:
 */

@Mapper
public interface EmpMapper {

    //根据id删除数据
    @Delete("delete from emp where id = #{id}")
    //public void delete(Integer id);
    public int delete(Integer id);

    //新增员工
    @Options(keyProperty = "id",useGeneratedKeys = true)
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
    "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);


    //更新员工
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
            " job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update(Emp emp);

    //根据id查询员工

    // 存在表和对象中属性名不一致情况下，无法进行映射的情况，例如 dept_id（表中数据）   deptId（对象中的属性名）
    // 方式3：#开启mybatis的驼峰命名自动映射开关
    // mybatis.configuration.map-underscore-to-camel-case=true
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    //方式1： 给字段起别名，让别名与类的属性名一致
    // @Select("select id,username,password,name,gender,image,job,entrydate," +
    //         "dept_id,create_time createTime,update_time updateTime from emp where id = #{id}")
    // public Emp getById(Integer id);

    // 方式2：通过@Results注解手动映射封装
    // @Results({
    //         @Result(column = "dept_id",property = "deptId"),
    //         @Result(column = "create_time",property = "createTime"),
    //         @Result(column = "update_time",property = "updateTime")
    // })
    // @Select("select * from emp where id = #{id}")
    // public Emp getById(Integer id);


    //根据条件查询
    // @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} and " +
    //         "entrydate between #{begin} and  #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    //动态更新员工信息
    // @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}, image = #{image}," +
    //         " job = #{job}, entrydate = #{entrydate}, dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    public void update2(Emp emp);


    //批量删除
    public void deleteById(List<Integer> ids);


}
