package com.tge.service.impl;

import com.tge.dao.EmpDao;
import com.tge.pojo.Emp;
import com.tge.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: EmpServiceB
 * Package: com.tge.service.impl
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/16 - 23:57
 * Version:
 */

@Service
public class EmpServiceB implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        // 2. 对数据进行转换处理
        empList.forEach(emp -> {
            // 处理 gender 1：男   2：女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男士");
            }else {
                emp.setGender("女士");
            }

            // 处理 job 1：讲师   2：班主任   3：就业指导
            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if ("2".equals(job)) {
                emp.setJob("班主任");
            }else {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
