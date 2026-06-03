package com.garimpeiro.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garimpeiro.monitor.model.Colecao;
import com.garimpeiro.monitor.repository.ColecaoRepository;

@Service // Define esta classe como o componente de regras de negócio do Spring
public class ColecaoService {

    @Autowired
    private ColecaoRepository repository;

    // 1. CRIAR: Persiste uma nova Colecao no banco de dados
    public Colecao cadastrarNovaColecao(Colecao novaColecao) {
        return repository.save(novaColecao);
    }

    // 2. ATUALIZAR: Busca a coleção existente e atualiza os dados
    public Colecao atualizarColecao(Long id, Colecao colecaoAtualizada) {
        Colecao colecaoExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coleção não encontrada pelo ID: " + id));

        // Substitui o nome da coleção persistida pelo novo nome enviado
        colecaoExistente.setNome(colecaoAtualizada.getNome());
        
        // Persiste a entidade atualizada
        return repository.save(colecaoExistente);
    }

    // 3. LISTAR TODAS: Retorna todas as coleções cadastradas
    public List<Colecao> listarTodas() {
        return repository.findAll();
    }

    // 4. BUSCAR POR ID: Retorna uma coleção específica
    public Colecao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coleção não encontrada pelo ID: " + id));
    }

    // 5. DELETAR: Remove a coleção do banco de dados
    public void deletarColecao(Long id) {
        Colecao colecaoExistente = buscarPorId(id);
        repository.delete(colecaoExistente);
    }
}