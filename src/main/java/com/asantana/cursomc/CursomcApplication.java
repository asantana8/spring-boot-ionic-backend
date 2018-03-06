package com.asantana.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.asantana.cursomc.domain.Categoria;
import com.asantana.cursomc.domain.Cidade;
import com.asantana.cursomc.domain.Cliente;
import com.asantana.cursomc.domain.Endereco;
import com.asantana.cursomc.domain.Estado;
import com.asantana.cursomc.domain.Produto;
import com.asantana.cursomc.domain.enums.TipoCliente;
import com.asantana.cursomc.repositories.CategoriaRepository;
import com.asantana.cursomc.repositories.CidadeRepository;
import com.asantana.cursomc.repositories.ClienteRepository;
import com.asantana.cursomc.repositories.EnderecoRepository;
import com.asantana.cursomc.repositories.EstadoRepository;
import com.asantana.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Capminas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva", "maria@gmail.com","12345678911",TipoCliente.PESSOAFISICO);
		cli1.getTelefones().addAll(Arrays.asList("81998773504","81998993816"));
		
		Endereco e1 = new Endereco(null,"Rua Flores","300","Apto.101","Jardim","50630190",cli1, cid1);
		Endereco e2 = new Endereco(null,"Rua Francisco","301","Apto.102","Cordeiro","50630190",cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(cli1);
		enderecoRepository.save(Arrays.asList(e1,e2));
	}
}
