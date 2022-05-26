package com.dambroski.primeiro_projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.primeiro_projeto.domain.Cliente;
import com.dambroski.primeiro_projeto.repositories.ClienteRepository;
import com.dambroski.primeiro_projeto.services.exceptions.ObjectNotFoundExeception;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
	}

}
