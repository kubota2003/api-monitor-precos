package com.garimpeiro.monitor.repository;

import com.garimpeiro.monitor.model.Colecao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Avisa ao Spring que este arquivo cuida do acesso ao banco de dados
public interface ColecaoRepository extends JpaRepository<Colecao, Long> {
    // Só de estender o JpaRepository, o Spring já cria sozinho métodos como:
    // .save() -> Para salvar uma coleção
    // .findAll() -> Para listar todas as coleções
    // .findById() -> Para buscar uma coleção específica
    // .delete() -> Para apagar uma coleção
}