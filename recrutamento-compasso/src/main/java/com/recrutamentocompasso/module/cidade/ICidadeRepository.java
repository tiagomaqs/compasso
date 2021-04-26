package com.recrutamentocompasso.module.cidade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.recrutamentocompasso.model.Cidade;

public interface ICidadeRepository extends CrudRepository<Cidade, Long>, QueryByExampleExecutor<Cidade>, ICidadeRepositoryCustom{

}
