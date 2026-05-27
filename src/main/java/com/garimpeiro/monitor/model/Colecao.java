package com.garimpeiro.monitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Avisa ao JPA que isso aqui vai virar uma tabela chamada "colecao" no SQL
public class Colecao {

    @Id // Define este campo como a Chave Primária (ID único)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID automaticamente (1, 2, 3...)
    private Long id;

    private String nome; // Nome da pasta, ex: "Re:Zero - Light Novels"
    private String descricao; // Uma nota sua, ex: "Coleção física da NewPOP"

    // --- GETTERS E SETTERS TRADICIONAIS ---
    // Como decidimos não usar o Lombok para evitar problemas no Eclipse, criamos os métodos padrão.
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}