package com.asantana.cursomc.dto;

import java.io.Serializable;
import java.util.Date;

import com.asantana.cursomc.domain.Pagamento;
import com.asantana.cursomc.domain.PagamentoComBoleto;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PagamentoComBoletoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento;
	
	public PagamentoComBoletoDTO() {		
	}

	public PagamentoComBoletoDTO(Date dataVencimento, Date dataPagamento) {
		super();
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	
	public PagamentoComBoletoDTO(PagamentoComBoleto obj) {
		super();
		this.dataVencimento = obj.getDataVencimento();
		this.dataPagamento = obj.getDataPagamento();
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	
	

}
