package com.garimpeiro.monitor.controller;

import com.garimpeiro.monitor.model.Colecao;
import com.garimpeiro.monitor.repository.ColecaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Coloca o "uniforme de garçom" na classe. Ela agora atende requisições Web.
@RequestMapping("/colecoes") // Define o endereço. Tudo aqui será acessado via /colecoes
public class ColecaoController {

    @Autowired // MÁGICA: Conecta o garçom com o cozinheiro automaticamente
    private ColecaoRepository repository;

    // Rota para LER dados (Equivale a pedir para ver o cardápio)
    @GetMapping
    public List<Colecao> listarTodas() {
        return repository.findAll(); // Vai no banco e traz todas as pastas salvas
    }

    // Rota para SALVAR dados (Equivale a fazer um novo pedido)
    @PostMapping
    public Colecao criarNova(@RequestBody Colecao novaColecao) {
        return repository.save(novaColecao); // Salva a nova pasta no banco de dados
    }
}