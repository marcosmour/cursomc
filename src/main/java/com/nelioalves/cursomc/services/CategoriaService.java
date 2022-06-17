// ESSA E A CAMADA DE SERVIÇOS // TRABALHA EM CONJUNTO COM A CLASSE CATEGORIARESOURCE

package com.nelioalves.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.DataIntegrityException;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; // ESSE FAZ A LIGAÇÃO COM A CLASSE CATEGORIAREPOSITORY
	
	// PARA PEGAR DADOS
	public Categoria find(Integer id) { // ESSE COMANDO SERVE PARA BUSCAR NO CATEGORIAREPOSITORY
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	// PARA INSERIR DADOS 
	public Categoria insert(Categoria obj) {
		obj.setId(null); // PARA GARANTIR QUE O OBJETO A SER INSERIDO SERA NULL
		return repo.save(obj);
	}
	
	// PARA ATUALIZAR DADOS
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	// PARA DELETAR DADOS
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possiu produtos");
		}
		
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){ // PARA FASER UMA BUSCA COM PAGINAÇÃO AULA 38.
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
