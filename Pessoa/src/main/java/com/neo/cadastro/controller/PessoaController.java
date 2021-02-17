package com.neo.cadastro.controller;

import com.neo.cadastro.dto.request.PessoaRequest;
import com.neo.cadastro.dto.response.PessoaResponse;
import com.neo.cadastro.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponse> inserir(@RequestBody PessoaRequest pessoaRequest){
        PessoaResponse pessoaResponse = pessoaService.inserir(pessoaRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoaResponse.getId()).toUri();
        return ResponseEntity.created(location).body(pessoaResponse);
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar(){
        List<PessoaResponse> pessoaResponse = pessoaService.listar();
        return ResponseEntity.ok(pessoaResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> obter(@PathVariable String id){
        PessoaResponse pessoaResponse = pessoaService.obter(id);
        return ResponseEntity.ok(pessoaResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponse> atualizar(@RequestBody PessoaRequest pessoaRequest){
        PessoaResponse pessoaResponse = pessoaService.atualizar(pessoaRequest);
        return ResponseEntity.ok(pessoaResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
