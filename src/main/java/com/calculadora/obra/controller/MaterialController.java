package com.calculadora.obra.controller;

import com.calculadora.obra.dto.ConcretoPedido;
import com.calculadora.obra.dto.ConcretoResposta;
import com.calculadora.obra.dto.TijoloPedido;
import com.calculadora.obra.dto.TijoloResposta;
import com.calculadora.obra.service.MaterialService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materiais")

// Essa classe é responsável por gerenciar a interface de acesso aos métodos para calculo de volume de concreto e tijolos
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }

    @PostMapping("/concreto")
    public ResponseEntity<ConcretoResposta> calcularConcreto(@Valid @RequestBody ConcretoPedido request) {
        return ResponseEntity.ok(materialService.calcularVolumeConcreto(request));
    }

    @PostMapping("/tijolos")
    public ResponseEntity<TijoloResposta> calcularTijolos(@Valid @RequestBody TijoloPedido request) {
        return ResponseEntity.ok(materialService.calcularQuantidadeTijolos(request));
    }
}
