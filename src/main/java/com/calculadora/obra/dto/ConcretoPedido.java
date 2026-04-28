package com.calculadora.obra.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ConcretoPedido {

    @Valid
    @NotEmpty(message = "A lista de arestas não pode estar vazia.")
    private List<ArestaPedido> arestas;

    @NotNull(message = "A altura da viga é obrigatória.")
    @DecimalMin(value = "0.0001", message = "A altura da viga deve ser maior que zero.")
    private Double alturaViga;

    public List<ArestaPedido> getArestas() {
        return arestas;
    }

    public void setArestas(List<ArestaPedido> arestas) {
        this.arestas = arestas;
    }

    public Double getAlturaViga() {
        return alturaViga;
    }

    public void setAlturaViga(Double alturaViga) {
        this.alturaViga = alturaViga;
    }
}
