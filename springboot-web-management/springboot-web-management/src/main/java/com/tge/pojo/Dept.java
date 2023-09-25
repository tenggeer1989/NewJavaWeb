package com.tge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * ClassName: Dept
 * Package: com.tge.pojo
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/20 - 21:46
 * Version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    private Integer id; //ID
    private String name; //部门名称
    private LocalDateTime createTime; //创建时间
    private LocalDateTime updateTime; //修改时间
}
