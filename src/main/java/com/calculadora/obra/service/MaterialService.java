package com.calculadora.obra.service;

import com.calculadora.obra.dto.*;
import com.calculadora.obra.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class MaterialService {

    public ConcretoResposta calcularVolumeConcreto(ConcretoPedido request) {
        double volumeTotal = request.getArestas().stream().mapToDouble(
                a -> a.getEspessura() * request.getAlturaViga() * a.getComprimento()).sum();


        return new ConcretoResposta(BigDecimal.valueOf(volumeTotal).setScale(4, RoundingMode.HALF_UP),
                request.getArestas().size(), "Volume de concreto calculado com sucesso!");
    }

    public TijoloResposta calcularQuantidadeTijolos(TijoloPedido request) {
        double areaTotalParedes = 0;
        double areaTotalAberturas = 0;

        for (ArestaPedido aresta : request.getArestas()) {
            // Área bruta da parede
            areaTotalParedes += aresta.getComprimento() * aresta.getAlturaParede();

            // Subtração de aberturas
            if (aresta.isPossuiPorta()) {
                areaTotalAberturas += (aresta.getAlturaPorta() * aresta.getLarguraPorta());
            }
            if (aresta.isPossuiJanela()) {
                areaTotalAberturas += (aresta.getAlturaJanela() * aresta.getLarguraJanela());
            }
        }

        double areaLiquida = areaTotalParedes - areaTotalAberturas;
        double areaUmTijolo = request.getAlturaTijolo() * request.getLarguraTijolo();

        // Quantidade base e aplicação do percentual de perda
        int quantidadeBase = (int) Math.ceil(areaLiquida / areaUmTijolo);
        int quantidadeComPerda = (int) Math.ceil(quantidadeBase * (1 + (request.getPercentualPerda() / 100)));

        TijoloResposta resposta = new TijoloResposta();
        resposta.setAreaTotalParedes(BigDecimal.valueOf(areaTotalParedes).setScale(2, RoundingMode.HALF_UP));
        resposta.setAreaAberturas(BigDecimal.valueOf(areaTotalAberturas).setScale(2, RoundingMode.HALF_UP));
        resposta.setAreaLiquidaParedes(BigDecimal.valueOf(areaLiquida).setScale(2, RoundingMode.HALF_UP));
        resposta.setQuantidadeTijolos(quantidadeBase);
        resposta.setQuantidadeTijolosComPerda(quantidadeComPerda);
        resposta.setMensagem("Quantidade de tijolos calculada com sucesso!");

        return resposta;
    }

}

