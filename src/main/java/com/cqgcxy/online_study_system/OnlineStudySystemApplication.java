package com.cqgcxy.online_study_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.cqgcxy.online_study_system.dao")
@SpringBootApplication
public class OnlineStudySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineStudySystemApplication.class, args);
    }

}
