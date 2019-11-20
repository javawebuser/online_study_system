package com.cqgcxy.online_study_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class uploadConterllor {
    @ResponseBody
    @PostMapping("/upload")
    public Map<String, String> upload(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            Map<String, String> path = new HashMap<>();
            path.put("path", "上传失败");
            return path;
        }
        //创建本地文件
        String classpath = "/D:/IDEA/online_study_system/src/main/resources";
        System.out.println(classpath);
        //创建一个日期对象
        Date d=new Date();
        System.out.println(d);
                /*//创建一个格式化对象
                SimpleDateFormat sdf=new SimpleDateFormat();
                System.out.println(sdf);*/
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        //格式化为日期/时间字符串
        String cc=sdf.format(d);
        File localFile = new File(classpath + "/upload", file.getOriginalFilename());
        //把传上来的文件写到本地文件
        file.transferTo(localFile);
        //获取上传的文件
        File file1 = new File(classpath + "/upload"+"/"+file.getOriginalFilename());
        //获取文件后缀
        String str = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //获取修改文件路径
        String c=file1.getParent();
        //修改后文件的路径
        File mm = new File(c+"/"+cc+"."+str);
        //修改文件名字
        file1.renameTo(mm);
        //返回修改后的文件名字
        Map<String, String> path = new HashMap<>();
        path.put("path", cc+"."+str);
        return path;
    }
}
