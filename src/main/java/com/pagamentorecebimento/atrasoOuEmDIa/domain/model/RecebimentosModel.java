package com.pagamentorecebimento.atrasoOuEmDIa.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecebimentosModel {

    private Long codigo;
    private String status;
    private BigDecimal valorAReceber;
    private BigDecimal diferencaValor;
    private BigDecimal valorRecebido;
}
