package com.asantana.cursomc.dto;

import java.io.Serializable;
import java.util.Date;

import com.asantana.cursomc.domain.Cliente;
import com.asantana.cursomc.domain.Endereco;
import com.asantana.cursomc.domain.Pagamento;
import com.asantana.cursomc.domain.Pedido;

public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date instante;
	private Pagamento pagamento;
	private Cliente cliente;
	private Endereco enderecoDeEntrega;
	
	public PedidoDTO() {		
	}

	public PedidoDTO(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoDeEntrega) {
		super();
		this.id = id;
		this.instante = instante;
		this.pagamento = pagamento;
		this.cliente = cliente;
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	public PedidoDTO(Pedido obj) {
		super();
		this.id = obj.getId();
		this.instante = obj.getInstante();
		this.pagamento = obj.getPagamento();
		this.cliente = obj.getCliente();
		this.enderecoDeEntrega = obj.getEnderecoDeEntrega();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInstante() {
		return instante;
	}

	public void setInstante(Date instante) {
		this.instante = instante;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Endereco getEnderecoDeEntrega() {
		return enderecoDeEntrega;
	}

	public void setEnderecoDeEntrega(Endereco enderecoDeEntrega) {
		this.enderecoDeEntrega = enderecoDeEntrega;
	}
	
	

}
