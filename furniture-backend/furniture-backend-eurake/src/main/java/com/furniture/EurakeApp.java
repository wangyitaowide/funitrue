package com.furniture;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 *@ComponentScan(basePackages="com.example")
 */
@EnableEurekaServer
@SpringBootApplication
public class EurakeApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(EurakeApp.class, args);
    }
}
