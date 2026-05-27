package com.garimpeiro.monitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.math.BigDecimal;

@Entity // Vira a tabela "item" no banco de dados
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo; // Nome do item, ex: "Re:Zero Volume 6"
    private String urlProduto; // O link da Amazon que o Python vai ler
    private BigDecimal precoAtual; // Preço que está na Amazon hoje
    private BigDecimal precoAlvo; // Quanto você quer pagar (Sua Meta!)
    private String prioridade; // "Alta", "Média" ou "Baixa"
    private boolean possuo; // Checkbox para marcar se você já comprou

    @ManyToOne // REGRA DE OURO: Muitos itens pertencem a UMA coleção (Muitos para Um)
    @JoinColumn(name = "colecao_id") // Cria a chave estrangeira no banco linkando com a Coleção
    private Colecao colecao;

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getUrlProduto() { return urlProduto; }
    public void setUrlProduto(String urlProduto) { this.urlProduto = urlProduto; }

    public BigDecimal getPrecoAtual() { return precoAtual; }
    public void setPrecoAtual(BigDecimal precoAtual) { this.precoAtual = precoAtual; }

    public BigDecimal getPrecoAlvo() { return precoAlvo; }
    public void setPrecoAlvo(BigDecimal precoAlvo) { this.precoAlvo = precoAlvo; }

    public String getPrioridade() { return prioridade; }
    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public boolean isPossuo() { return possuo; }
    public void setPossuo(boolean possuo) { this.possuo = possuo; }

    public Colecao getColecao() { return colecao; }
    public void setColecao(Colecao colecao) { this.colecao = colecao; }
}