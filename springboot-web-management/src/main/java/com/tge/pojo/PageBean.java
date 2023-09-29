package com.tge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageBean
 * Package: com.tge.pojo
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/21 - 0:00
 * Version:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageBean {

    private Long total;
    private List rows;
}
