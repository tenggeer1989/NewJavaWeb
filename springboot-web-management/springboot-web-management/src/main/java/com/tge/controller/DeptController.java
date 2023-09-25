package com.tge.controller;

import com.tge.pojo.Dept;
import com.tge.pojo.Result;
import com.tge.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * ClassName: DeptController
 * Package: com.tge.controller
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:49
 * Version:
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    //private static Logger log = LoggerFactory.getLogger(DeptController.class);
    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        List<Dept> deptList = deptService.list();

       return Result.success(deptList);
    }

    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id){
        log.info("根据ID删除部门：{}",id);
        deptService.deleteDept(id);
        return Result.success();
    }

    @PostMapping
    public Result addDeptByName(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.addDeptByName(dept);
        return Result.success();
    }
}
