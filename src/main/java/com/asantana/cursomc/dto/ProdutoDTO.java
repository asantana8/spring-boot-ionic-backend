package com.asantana.cursomc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.asantana.cursomc.domain.Categoria;
import com.asantana.cursomc.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Double preco;
	private List<Categoria> categorias = new ArrayList<>();
	
	public ProdutoDTO() {		
	}

	public ProdutoDTO(Integer id, String nome, Double preco, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.categorias = categorias;
	}
	
	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		this.categorias = obj.getCategorias();
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	

}
