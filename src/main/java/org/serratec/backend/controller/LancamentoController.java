package org.serratec.backend.controller;

import jakarta.validation.Valid;
import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.service.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoService.listaPorId(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendasResponseDTO inserir(@Valid @RequestBody LancamentoVendas lancamento) {
       return lancamentoService.inserir(lancamento);
    }
}
