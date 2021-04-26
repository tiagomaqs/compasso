package com.recrutamentocompasso.module.cidade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recrutamentocompasso.model.Cidade;
import com.recrutamentocompasso.module.cidade.model.CidadeFilter;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository cidadeRepository;
	
	public List<Cidade> find(CidadeFilter cidadeFilter) {
		return cidadeRepository.find(cidadeFilter);
	}
	
	public void save(Cidade cidade) {
		cidadeRepository.save(cidade);
	}

}
