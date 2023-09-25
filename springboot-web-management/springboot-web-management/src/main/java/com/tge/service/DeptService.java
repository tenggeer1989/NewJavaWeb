package com.tge.service;

import com.tge.pojo.Dept;

import java.util.List;

/**
 * ClassName: DeptService
 * Package: com.tge.service
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:51
 * Version:
 */
public interface DeptService {

    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 按照ID删除部门
     * @param id
     */
    void deleteDept(Integer id);

    /**
     * 新增部门
     */
    void addDeptByName(Dept dept);
}
