package com.furniture;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 *
 */
//@EnableCircuitBreaker//启用断路器,Hystrix dashboard必须启用
@MapperScan("com.furniture.dao")
@EnableEurekaClient//eurake客户端注册必须启用
@SpringBootApplication
public class Oauth2App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(Oauth2App.class, args);
    }
}
