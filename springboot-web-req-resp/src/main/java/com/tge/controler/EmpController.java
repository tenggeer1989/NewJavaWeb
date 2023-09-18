package com.tge.controler;

import com.tge.pojo.Emp;
import com.tge.pojo.Result;
import com.tge.service.EmpService;
import com.tge.service.impl.EmpServiceA;
import com.tge.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: EmpController
 * Package: com.tge.controler
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/16 - 21:42
 * Version:
 */
@RestController
public class EmpController {
    /*@Qualifier(("empServiceB"))
    @Autowired
    private EmpService empService;*/

    @Resource(name = "empServiceA")
    private EmpService empService;


    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> empList = empService.listEmp();

        // 3. 响应数据
        return Result.success(empList);
    }

    /*@RequestMapping("/listEmp")
    public Result list(){
        // 1. 加载并解析xml文件
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        // 2. 对数据进行转换处理
        empList.forEach(emp -> {
            // 处理 gender 1：男   2：女
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else {
                emp.setGender("女");
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

        // 3. 响应数据
        return Result.success(empList);
    }*/
}
