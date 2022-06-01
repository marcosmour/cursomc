// ESSE A CAMADA DE ACESSO A DADOS (REPOSITORY)

// SERVE PARA SALVAR AS CATEGORIAS - ESTA SENDO USADO NA CLASSE PRINCIPAL PARA SALVAR AS INFORMAÇOES NO BANCO DE DADOS

package com.nelioalves.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nelioalves.cursomc.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{ // COMANDO PARA ACESSO, ALTERAR, DELETAR ETC, DO OBJETO CATEGORIA

}
