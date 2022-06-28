package com.dambroski.primeiro_projeto.services;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dambroski.primeiro_projeto.domain.Cliente;
import com.dambroski.primeiro_projeto.repositories.ClienteRepository;
import com.dambroski.primeiro_projeto.services.exceptions.ObjectNotFoundExeception;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassoword(String email) {
		Cliente cliente = clienteRepository.findByEmail(email);
		if(cliente == null) {
			throw new ObjectNotFoundExeception("email não encontrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		emailService.sendNewPasswordEmail(Cliente cliente, String newPass);
	}
	
	private String newPassword() {
		 char[] vet = new char[10]; 
		 for(int i=0; i < 10; i++) {
			 vet[i] = randomChar();
		 }
		 return new String(vet);
	}
	
	private char randomChar() {
		int opt = rand.nextInt(3);
		if(opt == 0) {
			return (char)(rand.nextInt(10) + 48);
		}
		else if(opt == 1) {
			return (char)(rand.nextInt(26) + 65);
		}
		else {
			return (char)(rand.nextInt(26) + 97);
		}
	}

}
