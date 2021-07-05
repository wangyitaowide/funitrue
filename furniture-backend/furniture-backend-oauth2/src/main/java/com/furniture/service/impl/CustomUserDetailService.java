package com.furniture.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.furniture.entity.User;
import com.furniture.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserService userService;
	
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByName(username);
		if(user == null) {
			throw new UsernameNotFoundException("user not found");
		}
		//用户权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (StringUtils.isNotBlank(user.getRole())) {
            String[] roles = user.getRole().split(",");
            for (String role : roles) {
                if (StringUtils.isNotBlank(role)) {
                    authorities.add(new SimpleGrantedAuthority(role.trim()));
                }
            }
        }

		return new org.springframework.security.core.userdetails.User(user.getName(), bcryptPasswordEncoder.encode(user.getPassword()), authorities);
	}

}
