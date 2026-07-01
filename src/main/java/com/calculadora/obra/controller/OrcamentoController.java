package com.calculadora.obra.controller;

import com.calculadora.obra.model.Orcamento;
import com.calculadora.obra.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orcamentos")
public class OrcamentoController {

    @Autowired
    private OrcamentoRepository repository;

    @PostMapping
    public Orcamento criarOrcamento(@RequestBody Orcamento orcamento) {
        return repository.save(orcamento);
    }

    @GetMapping("/{id}")
    public Optional<Orcamento> buscarPorId(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/usuario")
    public List<Orcamento> buscarPorUsuario(@RequestParam String nome) {
        return repository.findByNomeUsuarioContainingIgnoreCase(nome);
    }
}