package com.garimpeiro.monitor.repository;

import com.garimpeiro.monitor.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Esta interface cuidará de salvar, buscar e atualizar todos os links e preços-alvo
}