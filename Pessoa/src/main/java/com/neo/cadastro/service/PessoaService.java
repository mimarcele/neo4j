package com.neo.cadastro.service;

import com.neo.cadastro.dto.request.PessoaRequest;
import com.neo.cadastro.dto.response.PessoaResponse;
import com.neo.cadastro.entities.Pessoa;
import com.neo.cadastro.exception.PessoaNotFoundException;
import com.neo.cadastro.mapper.MapperPessoaPessoaRequest;
import com.neo.cadastro.mapper.MapperPessoaPessoaResponse;
import com.neo.cadastro.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final MapperPessoaPessoaRequest mapperPessoaPessoaRequest;
    private final MapperPessoaPessoaResponse mapperPessoaPessoaResponse;
    private final PessoaRepository pessoaRepository;

    public PessoaResponse inserir(PessoaRequest pessoaRequest){
        Pessoa pessoa = mapperPessoaPessoaRequest.toEntity(pessoaRequest);

       pessoaRepository.save(pessoa);

       PessoaResponse pessoaResponse = mapperPessoaPessoaResponse.toDto(pessoa);

       return pessoaResponse;

    }

    public PessoaResponse obter(String id){
       // Pessoa pessoa = pessoaRepository.findByIdPessoa(id);
        Pessoa pessoa = pessoaRepository.findById(id).get();

        if(pessoa == null){
            throw new PessoaNotFoundException("Pessoa não encontrada para id" + id);
        }
        PessoaResponse pessoaResponse = mapperPessoaPessoaResponse.toDto(pessoa);
        return pessoaResponse;
    }

    public void deletar(String id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        if(pessoa == null){
            throw new PessoaNotFoundException("Pessoa não encontrada para id desejado");
        }
        pessoaRepository.delete(pessoa);
    }

    public PessoaResponse atualizar(PessoaRequest pessoaRequest){
        return Optional.of(pessoaRepository.findByNome(pessoaRequest.getNome()))
                .map(pessoa -> {
                    mapperPessoaPessoaRequest.toEntityUpdate(pessoaRequest, pessoa);
                    return pessoa;
                })
                .map(pessoaRepository::save)
                .map(mapperPessoaPessoaResponse::toDto)
                .orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada para nome solicitado"));

}

    public List<PessoaResponse> listar() {
         List<Pessoa> pessoa = (List<Pessoa>) pessoaRepository.findAll();

          if(pessoa == null){
            throw new PessoaNotFoundException("Não encontrado registro de pessoas no banco");
         }
         List<PessoaResponse> pessoas = pessoa
         .stream()
          .map(pessoa1 -> {
            PessoaResponse pessoaResponse = mapperPessoaPessoaResponse.toDto(pessoa1);
            return pessoaResponse;
         })
            .collect(Collectors.toList());
         return pessoas;
         }

    private Pessoa getPessoa(final String id){
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }

}
