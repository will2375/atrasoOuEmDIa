package com.pagamentorecebimento.atrasoOuEmDIa.integration.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "recebimentos")
public class RecebimentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @Column(length = 50,nullable = false)
    private String status;
    @Column(length = 10, nullable = false)
    private BigDecimal valorAReceber;
    @Column(length = 10, nullable = false)
    private BigDecimal diferencaValor;
    @Column(length = 10, nullable = false)
    private BigDecimal valorRecebido;
}
