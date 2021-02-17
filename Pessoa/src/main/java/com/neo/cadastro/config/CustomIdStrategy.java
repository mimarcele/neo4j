package com.neo.cadastro.config;

import org.neo4j.ogm.id.IdStrategy;

import java.util.UUID;

public class CustomIdStrategy implements IdStrategy {

    @Override
    public Object generateId(Object o) {
        return UUID.randomUUID().toString();
    }
}
