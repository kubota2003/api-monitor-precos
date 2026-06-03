package com.garimpeiro.monitor.controller;

import com.garimpeiro.monitor.model.Item;
import com.garimpeiro.monitor.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens") // Define o caminho base (endpoint) para este controlador
public class ItemController {

    @Autowired
    private ItemService service;

    // Endpoint para persistir uma nova entidade Item
    @PostMapping
    public Item cadastrar(@Valid @RequestBody Item novoItem) {
        return service.cadastrarNovoItem(novoItem);
    }

    // Endpoint para atualizar os dados de uma entidade Item existente pelo ID
    @PutMapping("/{id}")
    public Item atualizar(@PathVariable Long id, @Valid @RequestBody Item itemAtualizado) {
        return service.atualizarItem(id, itemAtualizado);
    }

    // Endpoint para listar todos os registros de Item no banco de dados
    @GetMapping
    public List<Item> listarTodos() {
        return service.listarTodos();
    }

    // Endpoint para buscar uma entidade Item específica pelo ID
    @GetMapping("/{id}")
    public Item buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    // Endpoint para remover uma entidade Item do banco de dados pelo ID
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletarItem(id);
    }
}