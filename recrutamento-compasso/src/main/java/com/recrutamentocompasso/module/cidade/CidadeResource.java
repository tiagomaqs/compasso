package com.recrutamentocompasso.module.cidade;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recrutamentocompasso.model.Cidade;
import com.recrutamentocompasso.module.cidade.model.CidadeFilter;

@RestController
@RequestMapping("/api/cidade")
public class CidadeResource {
	
	
	@Autowired
    private CidadeService cidadeService;
	
	@GetMapping
	public List<Cidade> find(CidadeFilter cidadeFilter) {
		return cidadeService.find(cidadeFilter);
	}
	
	@PostMapping
	public void save(@RequestBody @NotNull Cidade cidade) {
		cidadeService.save(cidade);
	}

	
}
