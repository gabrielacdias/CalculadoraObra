package com.calculadora.obra.dto;

import java.math.BigDecimal;

public class ConcretoResposta {

    private BigDecimal volumeTotal;
    private int quantidadeArestasProcessadas;
    private String mensagem;

    public ConcretoResposta() {
    }

    public ConcretoResposta(BigDecimal volumeTotal, int quantidadeArestasProcessadas, String mensagem) {
        this.volumeTotal = volumeTotal;
        this.quantidadeArestasProcessadas = quantidadeArestasProcessadas;
        this.mensagem = mensagem;
    }

    public BigDecimal getVolumeTotal() {
        return volumeTotal;
    }

    public void setVolumeTotal(BigDecimal volumeTotal) {
        this.volumeTotal = volumeTotal;
    }

    public int getQuantidadeArestasProcessadas() {
        return quantidadeArestasProcessadas;
    }

    public void setQuantidadeArestasProcessadas(int quantidadeArestasProcessadas) {
        this.quantidadeArestasProcessadas = quantidadeArestasProcessadas;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
