package com.tge.mapper;

import com.tge.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.tge.mapper
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:42
 * Version:
 */

@Mapper
public interface EmpMapper {

    /**
     * 查询员工总数
     * @return
     */
    // @Select("select count(*) from emp")
    // public Long count();


    /**
     * 分页查询获取列表数据
     * @param start
     * @param pageSize
     * @return
     */
    // @Select("select * from emp limit #{start},#{pageSize}")
    // public List<Emp> page(Integer start,Integer pageSize);

    /**
     * 通过PageHelper插件查询员工信息
     * @return
     */
    //@Select("select * from emp")
    public List<Emp> list(String name,Short gender, LocalDate begin, LocalDate end);


    /**
     * 批量删除员工
     * @param ids
     */
    public void delete(List<Integer> ids);

    /**
     * 新增员工
     */
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID查询员工
     * @return
     */
    @Select("select * from emp where  id = #{id}")
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
}
