package org.serratec.backend.dto;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record LancamentoVendasResponseDTO(LocalDate dataVenda, Double valorVenda, String nomeVendedor)  {
}
