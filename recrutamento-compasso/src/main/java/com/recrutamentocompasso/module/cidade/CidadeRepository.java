package com.recrutamentocompasso.module.cidade;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.recrutamentocompasso.model.Cidade;
import com.recrutamentocompasso.module.cidade.model.CidadeFilter;

@Repository
public class CidadeRepository implements ICidadeRepositoryCustom{
	@Autowired
	EntityManager em;
	
	@Autowired
	ICidadeRepository iCidadeRepository;
	
	public List<Cidade> find(CidadeFilter cidadeFilter) {
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Cidade> query = builder.createQuery(Cidade.class);
		Root<Cidade> root = query.from(Cidade.class);
		
		Predicate predicate;
		Predicate predicateFinal = null;
		
		if(null != cidadeFilter.getNome()) {
			predicateFinal = builder.equal(builder.upper(root.get("nome")), cidadeFilter.getNome().toUpperCase());
		}
		
		if(null != cidadeFilter.getEstado()) {
			predicate = builder.equal(builder.upper(root.get("estado")), cidadeFilter.getEstado().toUpperCase());
			if(null != predicateFinal) {
				predicateFinal = builder.and(predicateFinal, predicate);
			} else {
				predicateFinal = predicate;
			}
		}
		
		if(predicateFinal!=null) {
			query.where(predicateFinal);
		}
		
		List<Cidade> cidades = em.createQuery(query.select(root)).getResultList();
		
		return cidades;
		
	}
	
	public Cidade save(Cidade cidade) {
		Cidade cidadeDB = iCidadeRepository.save(cidade);
		return cidadeDB;
		
	}

}
