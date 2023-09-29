package com.tge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ClassName: Emp
 * Package: com.tge.pojo
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/18 - 22:07
 * Version:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private short gender; // 性别 1：男 2：女
    private String image;
    private short job; // 职位
    private LocalDate entrydate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
