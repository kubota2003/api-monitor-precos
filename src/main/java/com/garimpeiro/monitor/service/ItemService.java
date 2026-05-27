package com.garimpeiro.monitor.service;

import com.garimpeiro.monitor.model.Item;
import com.garimpeiro.monitor.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Coloca o "chapéu de Chef de Cozinha" nesta classe. Ela guarda as regras de negócio.
public class ItemService {

    @Autowired // O Chef pede ajuda ao Auxiliar de Estoque (Repository)
    private ItemRepository repository;

    // Método principal de criação de um item
    public Item cadastrarNovoItem(Item novoItem) {
        
        // --- AQUI FICARÁ A INTELIGÊNCIA NO FUTURO ---
        // Exemplo do que faremos mais pra frente:
        // 1. Pegar a URL do 'novoItem'
        // 2. Chamar o script Python para descobrir o preço na Amazon
        // 3. Atualizar o 'precoAtual' do item antes de salvar
        // 4. Verificar se precoAtual <= precoAlvo (Se sim, disparar alerta!)
        // ---------------------------------------------

        // Depois de aplicar todas as regras, o Chef manda o Auxiliar guardar no banco:
        return repository.save(novoItem);
    }
}