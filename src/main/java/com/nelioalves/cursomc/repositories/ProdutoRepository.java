// ESSE A CAMADA DE ACESSO A DADOS (REPOSITORY)

// SERVE PARA SALVAR AS CATEGORIAS - ESTA SENDO USADO NA CLASSE PRINCIPAL PARA SALVAR AS INFORMAÇOES NO BANCO DE DADOS

package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{ // esse e o comando para acesso, alterar, deletar etc, do objeto Categoria

}
