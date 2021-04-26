package com.recrutamentocompasso.module.cliente;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recrutamentocompasso.model.Cliente;
import com.recrutamentocompasso.module.cliente.model.ClienteFilter;

@Repository
public class ClienteRepository implements IClienteRepositoryCustom{
	@Autowired
	EntityManager em;
	
	@Autowired
	IClienteRepository iClienteRepository;
	
	public List<Cliente> findAll(ClienteFilter clienteFilter) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = builder.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		
		Predicate predicateFinal = null;
		
		if(null != clienteFilter.getNome()) {
			predicateFinal = builder.equal(builder.upper(root.get("nome")), clienteFilter.getNome().toUpperCase());
		}
		
		if(predicateFinal!=null) {
			query.where(predicateFinal);
		}
		
		List<Cliente> clientes = em.createQuery(query.select(root)).getResultList();
		
		return clientes;
		
	}
	
	public Optional<Cliente> find(Long id) {
		return iClienteRepository.findById(id);
	}
	
	public Cliente save(Cliente cliente) {
		Cliente clienteDB = iClienteRepository.save(cliente);
		return clienteDB;
		
	}

	public void delete(Long id) {
		iClienteRepository.deleteById(id);
	}

	public void update(Cliente clienteDB) {
		iClienteRepository.save(clienteDB);
	}

}
