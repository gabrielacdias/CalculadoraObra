package com.calculadora.obra.repository;

import com.calculadora.obra.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {
    List<Orcamento> findByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
}