package com.tge;

import com.tge.mapper.EmpMapper;
import com.tge.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void  testDelete () {
        int delete = empMapper.delete(17);
        System.out.println(delete);
    }

    @Test
    public void testInsert(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setImage("3.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    //更新员工
    @Test
    public void testUpdate(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000,1,1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        //执行更新员工操作
        empMapper.update(emp);
    }

    //根据ID查询员工
    @Test
    public void testGetById(){
        Emp emp = empMapper.getById(20);
        System.out.println(emp);
    }

    //条件查询员工信息
    @Test
    public void testList(){
        //List<Emp> list = empMapper.list("张", null, null, null);
        //List<Emp> list = empMapper.list("张", (short)1, null, null);
        //List<Emp> list = empMapper.list(null, (short)1, null, null);
        List<Emp> list = empMapper.list(null, null, null, null);

        System.out.println(list);
    }


    @Test
    public void testUpdate2(){
        //构造员工对象
        Emp emp = new Emp();
        emp.setId(19);
        emp.setUsername("Tom22234234");
        // emp.setName("汤姆222");
        // emp.setGender((short)1);
        // emp.setUpdateTime(LocalDateTime.now());

        //执行更新员工操作
        empMapper.update2(emp);
    }

    @Test
    public void testDeleteById(){
        List<Integer> list = Arrays.asList(18,19,20);

        empMapper.deleteById(list);
    }

}
