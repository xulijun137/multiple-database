package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//在SpringBootApplication标签后加上exclude
@SpringBootApplication  //(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.example.mapper") //扫描的mapper
public class MultipleDatabaseApplication {

    public static void main(String[] args) {

        SpringApplication.run(MultipleDatabaseApplication.class, args);
    }

}
