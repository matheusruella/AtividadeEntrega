package org.serratec.backend.service;

import org.serratec.backend.dto.LancamentoVendasResponseDTO;
import org.serratec.backend.entity.LancamentoVendas;
import org.serratec.backend.entity.Vendedor;
import org.serratec.backend.exception.LancamentoExcpetion;
import org.serratec.backend.repository.LancamentoRepository;
import org.serratec.backend.repository.VendedorRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;
    @Autowired
    private VendedorRepositoy vendedorRepositoy;

    public LancamentoVendasResponseDTO listaPorId(Long id) {
        Optional<LancamentoVendas> lancamento = lancamentoRepository.findById(id);
        if (!lancamento.isPresent()) {
            throw new LancamentoExcpetion("ID: " + id + " não encontrado");
        }
        LancamentoVendas l = lancamento.get();
        return new LancamentoVendasResponseDTO(l.getDataVenda(),l.getValorVenda(),l.getVendedor().getNome());
    }

    public LancamentoVendasResponseDTO inserir(LancamentoVendas lancamento) {
        Optional<LancamentoVendas> l = lancamentoRepository.findByCodigoVenda(lancamento.getCodigoVenda());
        if (l.isPresent()) {
            throw new LancamentoExcpetion("Venda já cadastrada");
        }
        Vendedor vendedor = null;
        Long codigo = lancamento.getVendedor().getCodigoVendedor();
        Optional<Vendedor> v = vendedorRepositoy.findById(codigo);
        if (v.isPresent()) {
            vendedor = v.get();
        }else {
            throw new LancamentoExcpetion("Vendedor não cadastrado");
        }
        lancamento.setVendedor(vendedor);
        LancamentoVendas lancamentoSalvo = lancamentoRepository.save(lancamento);
        return new LancamentoVendasResponseDTO(lancamentoSalvo.getDataVenda(),lancamentoSalvo.getValorVenda(),lancamentoSalvo.getVendedor().getNome());
    }


}
