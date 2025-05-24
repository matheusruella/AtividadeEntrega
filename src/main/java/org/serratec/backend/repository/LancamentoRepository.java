package org.serratec.backend.repository;

import org.serratec.backend.entity.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {

    Optional<LancamentoVendas> findByCodigoVenda(Long id);
}
