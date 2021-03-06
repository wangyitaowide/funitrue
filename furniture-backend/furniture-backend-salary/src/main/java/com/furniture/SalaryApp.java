package com.furniture;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 *
 */
@EnableEurekaClient//eurake客户端注册必须启用
@SpringBootApplication
public class SalaryApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(SalaryApp.class, args);
    }
}
