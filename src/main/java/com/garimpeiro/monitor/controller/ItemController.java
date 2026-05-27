package com.garimpeiro.monitor.controller;

import com.garimpeiro.monitor.model.Item;
import com.garimpeiro.monitor.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // Coloca o uniforme de garçom nesta classe
@RequestMapping("/itens") // A placa na porta: esta classe atende no endereço /itens
public class ItemController {

    @Autowired // O Garçom pede ajuda ao Chef de Cozinha (Service)
    private ItemService service;

    // Rota para cadastrar um novo link para garimpar
    @PostMapping
    public Item cadastrar(@RequestBody Item novoItem) {
        // O garçom não salva no banco. Ele entrega o pedido para o Chef!
        return service.cadastrarNovoItem(novoItem);
    }
}