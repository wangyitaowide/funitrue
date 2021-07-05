package com.furniture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class AuthoricationResourceConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception{
		//对指定api进行拦截
		http.authorizeRequests().antMatchers("/furniture-product/**").authenticated()
		.and().authorizeRequests().antMatchers("/furniture-oauth2/**").permitAll();
	}
}
