package com.recrutamentocompasso.module.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamentocompasso.model.Cliente;
import com.recrutamentocompasso.module.cliente.model.ClienteDTO;
import com.recrutamentocompasso.module.cliente.model.ClienteFilter;

@RestController
@RequestMapping("/api/cliente")
public class ClienteResource {
	
	@Autowired
    private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> findAll(ClienteFilter clienteFilter){
		return clienteService.findAll(clienteFilter);
		
	}
	
	@GetMapping("/{id}")
	public Cliente find(@PathVariable Long id){
		return clienteService.find(id);
		
	}
	
	@PostMapping
	public void save(@RequestBody Cliente cliente) {
		cliente.getNascimento().setDate(cliente.getNascimento().getDate()+1);
		clienteService.save(cliente);
	}
	
	@PutMapping("/{id}")
	public void delete(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
		clienteService.update(id, clienteDTO);		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
		clienteService.delete(id);		
	}

}
