package org.serratec.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class LancamentoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoVenda;
    @PastOrPresent
    private LocalDate dataVenda;

    private Double valorVenda;

    @ManyToOne
    @JoinColumn(name = "codigo_vendedor")
    private Vendedor vendedor;
}
