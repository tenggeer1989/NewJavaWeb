package com.tge.service;

import com.tge.pojo.Emp;
import com.tge.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * ClassName: EmpService
 * Package: com.tge.service
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:51
 * Version:
 */
public interface EmpService {


    /**
     * 查询所有员工信息
     */
    PageBean empList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    /**
     * 删除员工
     */
    void delete(List<Integer> ids);

    /**
     * 新增员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 根据id查询员工
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 更新员工信息
     * @param emp
     */
    void update(Emp emp);
}
