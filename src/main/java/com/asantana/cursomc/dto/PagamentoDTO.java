package com.asantana.cursomc.dto;

import java.io.Serializable;

import com.asantana.cursomc.domain.Pagamento;
import com.asantana.cursomc.domain.Pedido;
import com.asantana.cursomc.domain.enums.EstadoPagamento;

public class PagamentoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer estado;	
	private Pedido pedido;

	public PagamentoDTO(Integer id, EstadoPagamento estado, Pedido pedido) {
		super();
		this.id = id;
		this.estado = estado.getCod();
		this.pedido = pedido;
	}
	
	public PagamentoDTO(Pagamento obj) {
		super();
		this.id = obj.getId();
		this.estado = obj.getEstado().getCod();
		this.pedido = obj.getPedido();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public EstadoPagamento getEstado() {
		return EstadoPagamento.toEnum(estado);
	}
	
	public void setEstado(EstadoPagamento estado) {
		this.estado = estado.getCod();
	}
	
	public Pedido getPedido() {
		return pedido;
	}
	
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}	

}
