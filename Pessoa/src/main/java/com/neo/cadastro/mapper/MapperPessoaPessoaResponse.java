package com.neo.cadastro.mapper;

import com.neo.cadastro.dto.response.PessoaResponse;
import com.neo.cadastro.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperPessoaPessoaResponse {

    Pessoa toEntity(PessoaResponse pessoaResponse);
    PessoaResponse toDto(Pessoa pessoa);
    Pessoa toEntityUpdate(PessoaResponse pessoaResponse, @MappingTarget Pessoa pessoa);
}
