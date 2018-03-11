package com.asantana.cursomc.dto;

import java.io.Serializable;

import com.asantana.cursomc.domain.Cidade;
import com.asantana.cursomc.domain.Estado;

public class CidadeDTO  implements Serializable{
	public CidadeDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Estado estado;
	
	public CidadeDTO() {		
	}			
	
	public CidadeDTO(Integer id, String nome, Estado estado) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
	}

	public CidadeDTO(Cidade obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.estado = obj.getEstado();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
	

}
