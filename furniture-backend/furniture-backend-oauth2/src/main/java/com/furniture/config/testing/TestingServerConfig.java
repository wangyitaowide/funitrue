package com.furniture.config.testing;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.furniture.config.AuthoricationServerConfig;
import com.furniture.service.impl.CustomUserDetailService;

@Configuration
@EnableAuthorizationServer
public class TestingServerConfig extends AuthoricationServerConfig {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
    @Autowired
    private CustomUserDetailService userDetailsService;
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore())
		.authenticationManager(authenticationManager()).userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("client").secret(passwordEncoder.encode("123456"))
		.accessTokenValiditySeconds(36000).refreshTokenValiditySeconds(72000)
		.redirectUris("http://www.baidu.com").scopes("all")
		.authorizedGrantTypes("authorization_code","refresh_token");
	}
	
	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
//		return new JdbcTokenStore(dataSource);
	}
	
	//开启refresh_token需要配置
	@Bean
	public AuthenticationManager authenticationManager() {
		return new AuthenticationManager() {
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				return authenticationProvider().authenticate(authentication);
			}};
	}
	//开启refresh_token需要配置
	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userDetailsService);
		dao.setHideUserNotFoundExceptions(false);
		dao.setPasswordEncoder(passwordEncoder);
		return dao;
	}
}
