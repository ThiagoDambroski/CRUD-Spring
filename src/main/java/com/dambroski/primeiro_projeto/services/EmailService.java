package com.dambroski.primeiro_projeto.services;

import org.springframework.mail.SimpleMailMessage;

import com.dambroski.primeiro_projeto.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
