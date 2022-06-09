// ESSA E A CAMADA DE SERVIÇOS

package com.nelioalves.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;
import com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo; // ESSE FAZ A LIGAÇÃO COM A CLASSE CATEGORIAREPOSITORY
	
	public Categoria buscar(Integer id) { // ESSE COMANDO SERVE PARA BUSCAR NO CATEGORIAREPOSITORY
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null); // PARA GARANTIR QUE O OBJETO A SER INSERIDO SERA NULL
		return repo.save(obj);
	}
}
