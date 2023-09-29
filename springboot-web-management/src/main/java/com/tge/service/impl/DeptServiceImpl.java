package com.tge.service.impl;

import com.tge.mapper.DeptMapper;
import com.tge.mapper.EmpMapper;
import com.tge.pojo.Dept;
import com.tge.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: DeptServiceImpl
 * Package: com.tge.service.impl
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:50
 * Version:
 */

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deleteDept(Integer id) throws Exception {

        deptMapper.deleteDept(id);//根据id删除部门数据

        //int i = 1/0;
        if (true){
            throw new Exception("出错啦。。。");
        }

        empMapper.deleteByDeptId(id);//根据id删除该部门下的员工
    }

    @Override
    public void addDeptByName(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDeptByName(dept);
    }
}
