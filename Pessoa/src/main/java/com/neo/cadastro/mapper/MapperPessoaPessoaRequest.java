package com.neo.cadastro.mapper;

import com.neo.cadastro.dto.request.PessoaRequest;
import com.neo.cadastro.dto.response.PessoaResponse;
import com.neo.cadastro.entities.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface MapperPessoaPessoaRequest {

    Pessoa toEntity(PessoaRequest pessoaRequest);
    PessoaRequest toDto(Pessoa pessoa);
    Pessoa toEntityUpdate(PessoaRequest pessoaRequest, @MappingTarget Pessoa pessoa);
}
