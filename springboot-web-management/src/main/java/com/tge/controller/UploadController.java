package com.tge.controller;

import com.tge.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * ClassName: UploadController
 * Package: com.tge.controller
 * Description:
 *
 * @Author: tge
 * @Create: 2023/9/22 - 23:55
 * Version:
 */
@Slf4j
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传：{},{},{}",username,age,image);
        // 获取原始文件名
        String originalFilename = image.getOriginalFilename();

        // 构造唯一的文件名(不能重复  uuid)
        // 先获取扩展名
        int index = originalFilename.lastIndexOf("."); // 获取最后一个.的索引
        String extname = originalFilename.substring(index);// 通过最后一个点，进行截取字符串获得扩展名
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新文件名:{}",newFileName);


        // 将文件存储在本地服务器磁盘目录
        image.transferTo(new File("E:\\images\\" + newFileName));

        return Result.success();
    }
}
