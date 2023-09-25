package com.tge.service.impl;

import com.tge.mapper.LoginMapper;
import com.tge.pojo.Emp;
import com.tge.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: LoginServiceImpl
 * Package: com.tge.service.impl
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/25 - 16:15
 * Version:
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Emp login(Emp emp) {
        Emp emp1 = loginMapper.login(emp);
        return emp1;
    }
}
