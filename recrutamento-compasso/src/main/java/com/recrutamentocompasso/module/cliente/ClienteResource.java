package com.recrutamentocompasso.module.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamentocompasso.model.Cliente;
import com.recrutamentocompasso.module.cliente.model.ClienteFilter;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {
	
	@Autowired
    private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> findAll(ClienteFilter clienteFilter){
		return clienteService.find(clienteFilter);
		
	}
	
	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		clienteService.save(cliente);
	}

}
