package com.furniture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {

	/**
	 * 配置跨域
	 * @return
	 */
	@Bean
	public CorsWebFilter corsFilter() {
	   CorsConfiguration config = new CorsConfiguration();

	   config.setAllowCredentials(Boolean.TRUE);
	   config.addAllowedMethod("*");
	   config.addAllowedOrigin("*");
	   config.addAllowedHeader("*");
	   config.setMaxAge(3600L);

	   UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
	   source.registerCorsConfiguration("/**", config);

	   return new CorsWebFilter(source);
	}
}
