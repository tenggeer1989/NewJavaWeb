package com.tge.dao.impl;

import com.tge.dao.EmpDao;
import com.tge.pojo.Emp;
import com.tge.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: EmpDaoA
 * Package: com.tge.dao.impl
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/16 - 22:47
 * Version:
 */

@Repository
public class EmpDaoA implements EmpDao {

    @Override
    public List<Emp> listEmp() {
        // 1. 加载并解析xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
