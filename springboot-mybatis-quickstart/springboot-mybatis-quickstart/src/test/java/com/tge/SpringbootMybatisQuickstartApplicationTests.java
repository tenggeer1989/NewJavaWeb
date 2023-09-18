package com.tge;

import com.tge.mapper.UserMapper;
import com.tge.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testListUser(){
        List<User> list = userMapper.list();

        list.forEach(user -> {
            System.out.println(user);
        });
    }
}
