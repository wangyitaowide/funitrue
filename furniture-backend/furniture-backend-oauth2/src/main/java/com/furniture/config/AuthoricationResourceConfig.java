package com.furniture.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

//@Configuration
//@EnableResourceServer
public class AuthoricationResourceConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception{
		//对指定api进行拦截
//		http.authorizeRequests().antMatchers("/helloTest/**").authenticated();
//		表示当前url下所有匹配路径都放在资源服务器中，指放行的资源
		http.authorizeRequests().antMatchers("/oauth/**","/login/**","/logout/**").permitAll().anyRequest().authenticated().and().requestMatchers().antMatchers("/helloTest/**");
	}
}
