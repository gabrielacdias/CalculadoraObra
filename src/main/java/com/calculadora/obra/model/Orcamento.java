package com.calculadora.obra.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeUsuario;

    @Column(nullable = false)
    private Double areaTotal;

    @Column(nullable = false)
    private Integer numComodos;

    // Construtores, Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeUsuario() { return nomeUsuario; }
    public void setNomeUsuario(String nomeUsuario) { this.nomeUsuario = nomeUsuario; }
    public Double getAreaTotal() { return areaTotal; }
    public void setAreaTotal(Double areaTotal) { this.areaTotal = areaTotal; }
    public Integer getNumComodos() { return numComodos; }
    public void setNumComodos(Integer numComodos) { this.numComodos = numComodos; }
}