package com.furniture.config;

import java.security.KeyPair;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.bootstrap.encrypt.KeyProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import com.furniture.service.impl.CustomUserDetailService;

//@Configuration
//@EnableAuthorizationServer
public class AuthoricationServerConfig extends AuthorizationServerConfigurerAdapter {
	
//	@Autowired
//    private JwtTokenEnhancer jwtTokenEnhancer;
	
//	@Autowired
//    private TokenStore tokenStore;

//    @Autowired
//    private JwtAccessTokenConverter jwtAccessTokenConverter;
	
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Autowired
//    private CustomUserDetailService userDetailsService;
    
    @Resource
    private DataSource dataSource;
    
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
    
    @Autowired
    private ClientDetailsService clientDetailsService;
    
	/**配置appid、appkey、回调地址、有效期
	     * 客户端（第三方应用）相关配置
	     * 配置客户端（应用）信息  非用户信息
	     * 客户端详细信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
	     * 这里的代码在第一次请求获取token的时候会向数据库的表oauth_client_details插入数据，
         *由于client名称的唯一性约束，第二次请求就会出现报错，所以请求一次后需要注释掉，理论上数据库的数据应该是从其他业务逻辑添加好的数据
         *配置从哪里获取ClientDetails信息。
         * 在client_credentials授权方式下，只要这个ClientDetails信息。
     * @param clients
     * @throws Exception
     */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//	    super.configure(clients);
		clients.withClientDetails(clientDetailsService);
		clients.jdbc(dataSource);//将下面一段替换为此代表所有数据从数据库中查询，后面有参数会自动往数据库中添加记录，如果表中有此记录会启动报错
		/*clients.inMemory()
        // 配置客户端Id
        .withClient("client")
        //appkey
        // 客户端密钥 “{}”为加密方式 noop为不加密
        // 现如今Spring Security中密钥的存储格式是“{id}…………” 所以“{}”必要 否则报错：There is no PasswordEncoder mapped for the id “null”
        .secret(bcryptPasswordEncoder.encode("123456"))
        //.secret(bcryptPasswordEncoder.encode("{noop}123456"));
        // 配置授权范围 read、write、all
        .scopes("all")
        // 配置该客户端支持的授权方式，refresh_token刷新token
        .authorizedGrantTypes("authorization_code","password","client_credentials","refresh_token","implicit")
        .redirectUris("http://www.baidu.com")//该地址是第三方应用注册的地址,回调地址
        // token令牌有效期 单位s
        .accessTokenValiditySeconds(1800)
        // refreshtoken刷新令牌有效期 单位s 一般来说刷新令牌比令牌有效期长 便于使用刷新令牌换取令牌
        .refreshTokenValiditySeconds(3600)
        .autoApprove(true); //登录后绕过批准询问(/oauth/confirm_access);
*/        // 基本上来说 到这一步就完成了一个客户端的配置了
        // 如果想要配置多个客户端 往下使用.and()连接
        //.and()
		//.withClient()
    	//.secret()
    	//.scopes()
    	//.authorizedGrantTypes()
    	//.accessTokenValiditySeconds()
    	//.refreshTokenValiditySeconds();
	}
	
	//配置用户源,密碼模式需要重寫此方法，授權碼模式不需要
	//配置授权服务器端点的属性和增强的功能。这只token类型
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//	    super.configure(endpoints);
//		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();//jwt token内容增强，增加自定义声明
//        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtTokenEnhancer, jwtAccessTokenConverter));//jwt token内容增强，增加自定义声明

/*        endpoints.tokenStore(tokenStore)
//                .accessTokenConverter(jwtAccessTokenConverter)//jwt生成配置
//                .tokenEnhancer(tokenEnhancerChain)//jwt token内容增强，增加自定义声明
                .authenticationManager(authenticationManager)//刷新token要加，否则刷新令牌接口报错
//                .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.POST)//配置请求方式
                .userDetailsService(userDetailsService);//刷新token要加，否则刷新令牌接口报错
*/	}
	//配置授权服务器安全信息
	/**
	 *  配置：安全检查流程,用来配置令牌端点（Token Endpoint）的安全与权限访问
	 *  默认过滤器：BasicAuthenticationFilter
	 *  1、oauth_client_details表中clientSecret字段加密【ClientDetails属性secret】
	 *  2、CheckEndpoint类的接口 oauth/check_token 无需经过过滤器过滤，默认值：denyAll()
	 * 对以下的几个端点进行权限配置：
	 * /oauth/authorize：授权端点
	 * /oauth/token：令牌端点
	 * /oauth/confirm_access：用户确认授权提交端点
	 * /oauth/error：授权服务错误信息端点
	 * /oauth/check_token：用于资源服务访问的令牌解析端点
	 * /oauth/token_key：提供公有密匙的端点，如果使用JWT令牌的话
	 **/
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//	    super.configure(security);
		security.allowFormAuthenticationForClients()//允许客户表单认证
		.passwordEncoder(bcryptPasswordEncoder)//设置oauth_client_details中的密码编码器
		.checkTokenAccess("permitAll()")//允许check_code访问
//		.checkTokenAccess("isAuthenticated()")
		.tokenKeyAccess("permitAll()");
	}
	
}
