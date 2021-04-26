package com.recrutamentocompasso.module.cliente;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.recrutamentocompasso.model.Cliente;
import com.recrutamentocompasso.module.cliente.model.ClienteDTO;
import com.recrutamentocompasso.module.cliente.model.ClienteFilter;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> findAll(ClienteFilter clienteFilter) {
		return clienteRepository.findAll(clienteFilter);
	}
	
	public Cliente find(Long id) {
		Optional<Cliente> clienteOP = clienteRepository.find(id);
		return clienteOP.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void delete(Long id) {
		find(id);		
		clienteRepository.delete(id);
	}

	public void update(Long id, ClienteDTO clienteDTO) {
		Cliente clienteDB = find(id);
		clienteDB.setNome(clienteDTO.getNome());
		clienteRepository.update(clienteDB);
	}

}
