package com.tge.pojo;

import lombok.*;

import javax.management.loading.PrivateClassLoader;

/**
 * ClassName: User
 * Package: com.tge.pojo
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/17 - 21:29
 * Version:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private short age;
    private short gender;
    private String phone;

}
