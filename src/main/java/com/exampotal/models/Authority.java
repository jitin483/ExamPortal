package com.exampotal.models;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
public class Authority implements GrantedAuthority {

	/**
	 * Create Authority setter and getter already override from granted authority
	 */
	private String authority;
	
	public Authority(String authority) {
		this.authority=authority;
	}
	
	/*
	 * This is overrided form granted authority
	 */
	@Override
	public String getAuthority() {
		
		return authority;
	}

	@Override
	public String toString() {
		return "Authority [authority=" + authority + "]";
	}
	
	

}
