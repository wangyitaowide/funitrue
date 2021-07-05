package com.furniture.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.furniture.service.impl.CustomUserDetailService;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private CustomUserDetailService userDetailsService;
    
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    
    //在这里配置用户信息的来源及管理
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    super.configure(auth);
//		auth
//		.inMemoryAuthentication()
//		.userDetailsService(userDetailsService)
//		.passwordEncoder(bcryptPasswordEncoder);
//        .withUser("admin").password(bcryptPasswordEncoder.encode("123456")).roles("USER")
//        .and().withUser("test").password("test123").roles("ADMIN");
	}
	
	//配置网络安全
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		and()是指省略写多个http关联
//	    super.configure(http);
//		http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();//拦截所有请求使用httpbasic方式登陆
//		http.requestMatchers().antMatchers("/oauth/**","/login/**","logout/**")//不需要身份认证access("hasRole('ADMIN')")与直接写等效
//		.and().authorizeRequests().antMatchers("/oauth/**").access("hasRole('ADMIN')").authenticated()
//		.and().formLogin().loginProcessingUrl("/login/**").permitAll()//认证页面可以匿名访问
//		.and().csrf().disable();//关闭跨域保护
		//只允许路由由test开头的需要进行权限认证，其他的接口不需要权限认证；requestMatchers().anyRequest()即所有接口可以不进行认证；	
		http.csrf().disable().authorizeRequests().antMatchers("/oauth/**","/login/**","/logout/**").permitAll()
		.anyRequest().authenticated().and().formLogin().permitAll();
//		http.authorizeRequests().antMatchers("/**").permitAll();
/*		http.formLogin().loginPage("")//修改登录页面
		.loginProcessingUrl("/login/**")//认为是一个登录操作会执行自定义userdetail方法
		.successForwardUrl("")//登录成功后跳转页面必须post，前后端不分离时使用
		.successHandler(new SuccessHanlder(""))//与successForwardUrl不能共存，前后端分离使用
		.failureForwardUrl("")//登录失败跳转
		.usernameParameter("").passwordParameter("");//修改表单名称默认必须为username与password，设置账户密码参数名
*/
//		http.authorizeRequests().antMatchers("/oauth/**").permitAll().anyRequest().authenticated();
//		http.authorizeRequests().antMatchers("/oauth/**").hasAuthority("admin");//hasAnyAuthority多个参数，权限判断
//		http.authorizeRequests().antMatchers("/oauth/**").hasRole("admin");hasAnyRole多个参数，角色判断
//		hasIPAddress根据IP地址判断权限
		//antMatchers("/oauth/**"),一个/？表示匹配一个字符，一个/*表示匹配任意个字符，/**两个*表示任意个目录
//		antMatchers("/js/**").permitAll(),放行/resources/static/js下静态资源，antMatchers("/**/*.png")放行所有目录下png图片
//		regexMatchers()正则表达式匹配
//		mvcMatchers()
		
//		http.exceptionHandling().accessDeniedHandler(new DeniedHanlder())自定403处理方法，accessDeniedHandler实现AccessDeniedHandler接口
	
/*		http.rememberMe()
		.tokenValiditySeconds(60)//token失效时间
		.rememberMeParameter("")//修改默认参数remenber-me
		.userDetailsService(userDetailsService)//定义登录逻辑
		.tokenRepository(persistentTokenRepository);//持久层对象
*/	
//	http.logout().logoutUrl(logoutUrl),logoutSuccesUrl()	退出登录，默认直接请求/logout即可
	}
}
