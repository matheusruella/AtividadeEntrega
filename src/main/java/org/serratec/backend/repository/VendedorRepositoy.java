package org.serratec.backend.repository;

import org.serratec.backend.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendedorRepositoy extends JpaRepository<Vendedor, Long> {
    Optional<Vendedor> findByEmail(String email);
}
