package com.tge.controller;

import com.tge.pojo.Emp;
import com.tge.pojo.Result;
import com.tge.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: LoginController
 * Package: com.tge.controller
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/25 - 16:12
 * Version:
 */

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        Emp empList = loginService.login(emp);
        System.out.println();
        if(empList == null) {
            return Result.error("用户名或密码错误");
        }
        return Result.success();
    }
}
