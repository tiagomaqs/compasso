package com.recrutamentocompasso.module.cliente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.recrutamentocompasso.model.Cliente;

public interface IClienteRepository extends CrudRepository<Cliente, Long>, QueryByExampleExecutor<Cliente>, IClienteRepositoryCustom{

}
