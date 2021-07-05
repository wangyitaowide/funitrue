package com.furniture.config;

import java.security.KeyPair;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.furniture.service.impl.CustomUserDetailService;

//@Configuration
public class ClassConfig {
	
	@Autowired
	DataSource dataSource;

	@Autowired
	private CustomUserAuthenticationConverter customUserAuthenticationConverter;
	
    @Autowired
    private CustomUserDetailService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl impl = new JdbcTokenRepositoryImpl();
		impl.setDataSource(dataSource);
		//第一次运行执行，后面注释否则报错
//		impl.setCreateTableOnStartup(true);
		return impl;
	}
	
	@Bean
	public TokenStore tokenStore() {
//		return new JwtTokenStore(jwtAccessTokenConverter());
//		new RedisTokenStore(RedisConnectionFactory)
//	    return new InMemoryTokenStore(); //在内存中存放token
		return new JdbcTokenStore(dataSource);//在数据库中存放token
	}
	
	
	
	
	//读取密钥的配置
    @Bean("keyProp")
    public KeyProperties keyProperties(){
        return new KeyProperties();
    }

    @Resource(name = "keyProp")
    private KeyProperties keyProperties;
    
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		//读取密钥的配置
//		KeyProperties keyProperties = new KeyProperties();
        KeyPair keyPair = new KeyStoreKeyFactory(
                keyProperties.getKeyStore().getLocation(),                          //证书路径 changgou.jks
                keyProperties.getKeyStore().getSecret().toCharArray())              //证书秘钥 changgouapp
                .getKeyPair(
                        keyProperties.getKeyStore().getAlias(),                     //证书别名 changgou
                        keyProperties.getKeyStore().getPassword().toCharArray());   //证书密码 changgou
        converter.setKeyPair(keyPair);
        //配置自定义的CustomUserAuthenticationConverter
        DefaultAccessTokenConverter accessTokenConverter = (DefaultAccessTokenConverter) converter.getAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(customUserAuthenticationConverter);
		return converter;
	}
	
	@Bean
	public ClientDetailsService clientDetails() {
		return new JdbcClientDetailsService(dataSource);
	}
	

	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService);
		dao.setHideUserNotFoundExceptions(false);
		dao.setPasswordEncoder(bcryptPasswordEncoder());
		return dao;
	}
	
	@Bean
	public AuthenticationManager authenticationManager() {
		return new AuthenticationManager() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return authenticationProvider().authenticate(authentication);
			}};
	}
	
	@Bean
	public JwtTokenEnhancer jwtTokenEnhancer() {
		return new JwtTokenEnhancer();
	}
	
}
