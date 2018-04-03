package com.asantana.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asantana.cursomc.domain.Cidade;
import com.asantana.cursomc.dto.CidadeDTO;
import com.asantana.cursomc.repositories.CidadeRepository;
import com.asantana.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade find(Integer id) {
		Cidade obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto nao encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()); 
		}
		return obj;
	}

	public List<Cidade> findAll() {
		return repo.findAll();
	}

	public Cidade insert(Cidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Cidade update(Cidade obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public Cidade fromDto(CidadeDTO objDto) {
		return new Cidade(objDto.getId(), objDto.getNome(), objDto.getEstado());
	}	

}
