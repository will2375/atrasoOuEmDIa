package com.pagamentorecebimento.atrasoOuEmDIa.integration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@Table( name= "Pagamentos")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50, nullable = false)
    private String status;
    @Column(length = 10, nullable = false)
    private BigDecimal valorAPagar;
    @Column(length = 10)
    private BigDecimal diferencaValor;

    @Column(length = 10)
    private BigDecimal valorPago;
}