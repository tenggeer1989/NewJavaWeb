package com.tge.controler;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import com.tge.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: RequestController
 * Package: com.tge.controler
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/15 - 22:49
 * Version:
 */
@RestController
public class RequestController {
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(value = "name",required = false) String username, Integer age){
        System.out.println(username + ":" + age);
        return "OK";
    }

    // 实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "OK";
    }

    //数组
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    //集合
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "OK";
    }


    //日期时间类型
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = updateTime.format(formatter);
        System.out.println(formattedDateTime);
        return "OK";
    }

    //json
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    //路径参数
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable String id){
        System.out.println(id);
        return "OK";
    }

    //多个路径参数
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
