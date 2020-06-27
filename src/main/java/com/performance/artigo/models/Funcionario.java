package com.performance.artigo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Funcionario {
 
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    
    @ManyToOne
    private Empresa empresa;
    
    
    public Funcionario() {
	}
    
	public Funcionario(String name) {
		super();
		this.setNome(name);
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}