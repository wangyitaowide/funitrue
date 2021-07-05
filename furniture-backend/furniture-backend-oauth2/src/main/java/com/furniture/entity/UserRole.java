package com.furniture.entity;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class UserRole implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return null;
	}

}
