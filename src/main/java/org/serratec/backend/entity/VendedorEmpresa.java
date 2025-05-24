package org.serratec.backend.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("empresa")
public class VendedorEmpresa extends Vendedor{
    private String numeroCT;

    private LocalDate dataAdmissao;
}
