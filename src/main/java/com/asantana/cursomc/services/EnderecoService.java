package com.asantana.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.asantana.cursomc.domain.Endereco;
import com.asantana.cursomc.dto.EnderecoDTO;
import com.asantana.cursomc.repositories.EnderecoRepository;
import com.asantana.cursomc.services.exceptions.DataIntegrityException;
import com.asantana.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repo;
	
	public Endereco find(Integer id) {
		Endereco obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()); 
		}
		return obj;
	}
			
	public List<Endereco> findAll() {
		return repo.findAll();
	}
	
	public Page<Endereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Endereco update(Endereco obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);			
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma CATEGORIA que possui PRODUTOS!");
		}
		
	}

	public Endereco fromDTO(EnderecoDTO objDto) { 
		return new Endereco(objDto.getId(), objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), null, null);
	}
	
}
