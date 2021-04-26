package com.recrutamentocompasso.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue
    private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Enumerated(EnumType.ORDINAL)
	private Sexo sexo;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;
	
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
	public Cliente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public int getIdade() {
		if(null == getNascimento()) {
			return 0;
		}
		
		Date hoje = new Date();
		int idade = hoje.getYear() - this.nascimento.getYear();
		int mes = hoje.getMonth() - this.nascimento.getMonth();
		
		if(mes>0) {
			idade++;
		}else if(mes==0 && (hoje.getDate()>=this.nascimento.getDate())) {
			idade++;
		}
		return idade;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	
}
