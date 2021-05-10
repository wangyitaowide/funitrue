package com.furniture;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 *
 */
@MapperScan("com.furniture.dao")
@EnableEurekaClient//eurake客户端注册必须启用
@SpringBootApplication
public class WarehouseApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(WarehouseApp.class, args);
    }
}
