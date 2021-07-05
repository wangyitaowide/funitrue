package com.furniture;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;

/**
 * 
 *
 */
@EnableAutoDataSourceProxy
@MapperScan("com.furniture.dao")
@EnableEurekaClient//eurake客户端注册必须启用
@SpringBootApplication
public class ProductApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ProductApp.class, args);
    }
}
