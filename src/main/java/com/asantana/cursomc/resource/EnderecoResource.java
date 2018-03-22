package com.asantana.cursomc.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.asantana.cursomc.domain.Endereco;
import com.asantana.cursomc.dto.EnderecoDTO;
import com.asantana.cursomc.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Endereco> find(@PathVariable Integer id) {		
		Endereco obj = service.find(id);
		return ResponseEntity.ok(obj);		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findAll() {		
		List<Endereco> obj = service.findAll();
		return ResponseEntity.ok(obj);		
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EnderecoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="cidade") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {		
		Page<Endereco> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EnderecoDTO> listDto = list.map(obj -> new EnderecoDTO(obj));
		return ResponseEntity.ok(listDto);		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Endereco obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Endereco obj, @PathVariable Integer id){
		obj.setId(id);
		obj = service.update(obj);		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){		
		service.delete(id);		
		return ResponseEntity.noContent().build();
	}
}
