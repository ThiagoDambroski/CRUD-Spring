package com.dambroski.primeiro_projeto.services.exceptions;

public class AuthorizationExeception extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AuthorizationExeception(String msg) {
		super(msg);
	}
	
	public AuthorizationExeception(String msg, Throwable cause) {
		super(msg,cause);
	}

}
