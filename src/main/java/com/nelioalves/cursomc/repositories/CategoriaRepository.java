// ESSE A CAMADA DE ACESSO A DADOS (REPOSITORY)

package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{ // esse e o comando para acesso, alterar, deletar etc, do objeto Categoria

}
