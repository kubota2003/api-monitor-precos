package com.garimpeiro.monitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garimpeiro.monitor.model.Item;
import com.garimpeiro.monitor.repository.ItemRepository;

@Service // Coloca o "chapéu de Chef de Cozinha" nesta classe. Ela guarda as regras de negócio.
public class ItemService {

    @Autowired 
    private ItemRepository repository;

    // Método principal de criação de um item
public Item cadastrarNovoItem(Item novoItem) {
        
        /* TODO: Implementar lógica de integração com scraper em Python
         * 1. Extrair URL da entidade 'novoItem'.
         * 2. Acionar script Python em background para obter o preço atualizado da Amazon.
         * 3. Atualizar o atributo 'precoAtual' da entidade antes da persistência.
         * 4. Validar a regra de negócio (precoAtual <= precoAlvo) para disparar notificação.
         */
         
        // Persiste a entidade no banco de dados
        return repository.save(novoItem);
    }
    
 // Atualiza os dados de uma entidade Item existente com base no ID
    public Item atualizarItem(Long id, Item itemAtualizado) {
        
        // Busca a entidade no banco de dados via ItemRepository
        Item itemExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado pelo ID: " + id));

        // Substitui os atributos da entidade persistida pelos novos dados do payload
        itemExistente.setTitulo(itemAtualizado.getTitulo());
        itemExistente.setUrlProduto(itemAtualizado.getUrlProduto());
        itemExistente.setPrecoAtual(itemAtualizado.getPrecoAtual());
        itemExistente.setPrecoAlvo(itemAtualizado.getPrecoAlvo());
        itemExistente.setPrioridade(itemAtualizado.getPrioridade());
        itemExistente.setPossuo(itemAtualizado.isPossuo());

        // Persiste a entidade atualizada no banco de dados
        return repository.save(itemExistente);
    }
    
 // Retorna todas as entidades Item persistidas no banco de dados
    public List<Item> listarTodos() {
        return repository.findAll();
    }

    // Busca uma entidade Item específica pelo ID
    public Item buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado pelo ID: " + id));
    }

    // Remove uma entidade Item do banco de dados com base no ID
    public void deletarItem(Long id) {
        // Reutiliza o método de busca para garantir que a entidade existe antes de deletar
        Item itemExistente = buscarPorId(id);
        repository.delete(itemExistente);
    }
}