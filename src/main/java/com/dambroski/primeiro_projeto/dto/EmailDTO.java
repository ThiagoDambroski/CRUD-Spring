package com.dambroski.primeiro_projeto.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO implements Serializable{
	static final long serialVersionUID = 1L;
	
	
	@NotEmpty(message = "Peenchimento obrigatorio")
	@Email(message = "Email invalido")
	private String email;
	
	public EmailDTO() {
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
