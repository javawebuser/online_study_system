package com.cqgcxy.online_study_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class uploadConterllor {
    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam MultipartFile file) throws IOException {
        //创建本地文件
        String classpath = ResourceUtils.getURL("classpath:").getPath();
        File localFile = new File(classpath + "/upload", file.getOriginalFilename());
        //把传上来的文件写到本地文件
        file.transferTo(localFile);
        //返回localFile文件路径
        Map<String, String> path = new HashMap<>();
        path.put("path", localFile.getAbsolutePath());
        return path;
    }
}
