package com.furniture;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 *
 */
//@EnableCircuitBreaker//启用断路器,Hystrix dashboard必须启用
@ComponentScan(basePackages="com.furniture")
@EnableFeignClients//fegin调用必须启用
@EnableEurekaClient//eurake客户端注册必须启用
@SpringBootApplication
public class OrderApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(OrderApp.class, args);
    }
}
