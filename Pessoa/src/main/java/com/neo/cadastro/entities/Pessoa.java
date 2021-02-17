package com.neo.cadastro.entities;

import com.neo.cadastro.config.CustomIdStrategy;
import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NodeEntity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = CustomIdStrategy.class)
    private String id;

    private String nome;

    private String sobrenome;
}
