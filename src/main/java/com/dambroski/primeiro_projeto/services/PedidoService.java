package com.dambroski.primeiro_projeto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dambroski.primeiro_projeto.domain.Pedido;
import com.dambroski.primeiro_projeto.repositories.PedidoRepository;
import com.dambroski.primeiro_projeto.services.exceptions.ObjectNotFoundExeception;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundExeception(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
	}

}
