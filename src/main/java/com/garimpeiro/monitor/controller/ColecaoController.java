package com.garimpeiro.monitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.garimpeiro.monitor.model.Colecao;
import com.garimpeiro.monitor.service.ColecaoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/colecoes") // Define o endpoint base para as operações de coleção
public class ColecaoController {

    @Autowired
    private ColecaoService service;

    // Endpoint para persistir uma nova entidade Colecao
    @PostMapping
    public Colecao cadastrar(@Valid @RequestBody Colecao novaColecao) {
        return service.cadastrarNovaColecao(novaColecao);
    }

    // Endpoint para atualizar os dados de uma entidade Colecao existente pelo ID
    @PutMapping("/{id}")
    public Colecao atualizar(@PathVariable Long id, @Valid @RequestBody Colecao colecaoAtualizada) {
        return service.atualizarColecao(id, colecaoAtualizada);
    }

    // Endpoint para listar todos os registros de Colecao no banco de dados
    @GetMapping
    public List<Colecao> listarTodas() {
        return service.listarTodas();
    }

    // Endpoint para buscar uma entidade Colecao específica pelo ID
    @GetMapping("/{id}")
    public Colecao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Endpoint para remover uma entidade Colecao do banco de dados pelo ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarColecao(id);
    }
}