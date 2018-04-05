package com.asantana.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.asantana.cursomc.domain.Produto;
import com.asantana.cursomc.dto.ProdutoDTO;
import com.asantana.cursomc.repositories.ProdutoRepository;
import com.asantana.cursomc.services.exceptions.DataIntegrityException;
import com.asantana.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public Produto find(Integer id) {
		Produto obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id); 
		}
		return obj;
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Produto update(Produto obj) {
		Produto newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);			
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um PRODUTO que possui ITENS!");
		}
		
	}

	public Produto fromDTO(ProdutoDTO objDto) {
		return new Produto(objDto.getId(), objDto.getNome(), objDto.getPreco());
	}
	
	private void updateData(Produto newObj, Produto obj) {
		newObj.setNome(obj.getNome()==null ? newObj.getNome() : obj.getNome());
		newObj.setPreco(obj.getPreco()==null ? newObj.getPreco() : obj.getPreco());
	}

}
