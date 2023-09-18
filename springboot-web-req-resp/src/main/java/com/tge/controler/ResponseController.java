package com.tge.controler;

import com.tge.pojo.Address;
import com.tge.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ResbonseController
 * Package: com.tge.controler
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/15 - 23:56
 * Version:
 */
@RestController
public class ResponseController {

    /*@RequestMapping("/hello")
    public String hello(){
        System.out.println("Hello world~");
        return "hello world";
    }

    @RequestMapping("/getAddr")
    public Address getAddr(){
        Address addr = new Address();
        addr.setProvince("内蒙古");
        return addr;
    }


    @RequestMapping("/listAddr")
    public List<Address> listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setCity("huhhot");
        Address addr2 = new Address();
        addr2.setProvince("内蒙古");
        addr2.setCity("通辽");
        list.add(addr);
        list.add(addr2);
        return list;
    }*/


    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("Hello world~");
        return Result.success("Hello world~");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address addr = new Address();
        addr.setProvince("内蒙古");
        return Result.success(addr);
    }


    @RequestMapping("/listAddr")
    public Result listAddr(){
        List<Address> list = new ArrayList<>();

        Address addr = new Address();
        addr.setCity("huhhot");
        Address addr2 = new Address();
        addr2.setProvince("内蒙古");
        addr2.setCity("通辽");
        list.add(addr);
        list.add(addr2);
        return Result.success(list);
    }

}
