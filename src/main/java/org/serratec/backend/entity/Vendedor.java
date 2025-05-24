package org.serratec.backend.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo_vendedor"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = VendedorAutonomo.class, name = "autonomo"),
        @JsonSubTypes.Type(value = VendedorEmpresa.class, name = "empresa")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vendedor", discriminatorType = DiscriminatorType.STRING)
public abstract class Vendedor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long codigoVendedor;
   private String nome;
   private String email;
   private Double salario;

}
