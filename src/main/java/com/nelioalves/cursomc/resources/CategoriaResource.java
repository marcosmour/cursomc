//ESSE E UM CONTROLADOR REST

package com.nelioalves.cursomc.resources;

import java.net.URI;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
// PARA RECEBER UMA RESIÇÃO JSON E GERAR UMA CATEGORIA NO BANCO DE DADOS
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){ // O OBJ E O DADO QUE SERA INSERIDO NO BANCO DE DADOS
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri(); // PEGA A URI DO NOVO RECURSO INSERIDO GERAR URI E DAR UMA NUMERAÇÃO DO ID, GERADO AUTOMATICO NO BD
		return ResponseEntity.created(uri).build();
	}
}
