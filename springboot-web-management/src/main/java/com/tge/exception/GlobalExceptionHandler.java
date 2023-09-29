package com.tge.exception;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.tge.exception
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/28 - 23:47
 * Version:
 */

import com.tge.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//捕获所有异常
    public Result ex(Exception ex){
        ex.printStackTrace();
        return Result.error("操作失败，请联系管理员");
    }
}
