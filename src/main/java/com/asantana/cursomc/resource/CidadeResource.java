package com.asantana.cursomc.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.asantana.cursomc.domain.Cidade;
import com.asantana.cursomc.services.CidadeService;

@RestController
@RequestMapping(value="/cidades")
public class CidadeResource {

	@Autowired
	private CidadeService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {		
		Cidade obj = service.find(id);
		return ResponseEntity.ok(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findAll() {		
		List<Cidade> obj = service.findAll();
		return ResponseEntity.ok(obj);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(Cidade obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}
