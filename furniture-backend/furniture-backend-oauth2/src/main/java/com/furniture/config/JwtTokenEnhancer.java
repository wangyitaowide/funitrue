package com.furniture.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
/**
 * jwt内容增强，增加jwt自定义声明
 * @author ZZ04KO672
 *
 */
public class JwtTokenEnhancer implements TokenEnhancer {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("value", "value");
		DefaultOAuth2AccessToken acces = ((DefaultOAuth2AccessToken)accessToken);
		acces.setAdditionalInformation(map);
		return accessToken;
	}

}
