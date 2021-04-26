package com.recrutamentocompasso.module.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutamentocompasso.model.Cliente;
import com.recrutamentocompasso.module.cliente.model.ClienteFilter;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> find(ClienteFilter clienteFilter) {
		return clienteRepository.find(clienteFilter);
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}

}
