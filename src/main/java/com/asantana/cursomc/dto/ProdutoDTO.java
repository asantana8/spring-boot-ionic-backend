package com.asantana.cursomc.dto;

import java.io.Serializable;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.asantana.cursomc.domain.Categoria;
import com.asantana.cursomc.domain.Produto;

public class ProdutoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=2, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;			
	private Double preco;
	private String categoria;
	
	public ProdutoDTO() {		
	}

	public ProdutoDTO(Integer id, String nome, Double preco, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.setCategoria(categoria);
	}
	
	public ProdutoDTO(Produto obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.preco = obj.getPreco();
		List<Categoria> listCategoria = obj.getCategorias(); 
		this.setCategoria(listCategoria.get(0).getNome());
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


}
