package com.tge.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tge.mapper.EmpMapper;
import com.tge.pojo.Emp;
import com.tge.pojo.PageBean;
import com.tge.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ClassName: EmpServiceImpl
 * Package: com.tge.service.impl
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:50
 * Version:
 */

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;


    /*public PageBean empList(Integer page, Integer pageSize) {
        //1. 获取总记录数
        Long count = empMapper.count();

        //2. 获取所有记录
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        PageBean pageBean = new PageBean(count,empList);


        return pageBean;
    }*/

    @Override
    public PageBean empList(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1. 设置分页参数
        PageHelper.startPage(page,pageSize);

        //2. 执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;

        //3. 封装PageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());


        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
