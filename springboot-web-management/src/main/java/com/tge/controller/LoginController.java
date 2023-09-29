package com.tge.controller;

import com.tge.pojo.Emp;
import com.tge.pojo.Result;
import com.tge.service.LoginService;
import com.tge.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        Emp e = loginService.login(emp);

        //登录成功，生成令牌，下发令牌
        if (e != null){
            Map<String, Object> claims= new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);

            return Result.success(jwt);
        }

        //登录失败，返回错误信息
        return Result.error("用户名或密码错误");
    }
}
