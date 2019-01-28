package com.daicy.military;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.daicy.military.dao")
@EnableTransactionManagement(proxyTargetClass = true)
public class MilitaryApplication {

    public static void main(String[] args) {

        SpringApplication.run(MilitaryApplication.class, args);
    }

}

