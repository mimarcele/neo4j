package com.neo.cadastro.repository;

import com.neo.cadastro.entities.Pessoa;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends Neo4jRepository<Pessoa, String> {
    //Pessoa findByIdPessoa(String id);
    Pessoa findByNome(String nome);
}
