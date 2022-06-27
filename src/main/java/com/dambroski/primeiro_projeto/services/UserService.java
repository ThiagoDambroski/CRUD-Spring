package com.dambroski.primeiro_projeto.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.dambroski.primeiro_projeto.security.UserSS;

public class UserService {
	
	public static UserSS authenticated(){
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
		
	}
}
