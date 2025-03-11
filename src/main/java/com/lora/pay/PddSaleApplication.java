package com.lora.pay;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lora.pay.mapper")
public class PddSaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(PddSaleApplication.class, args);
    }


}
