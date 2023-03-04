package com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RecebimentoRest {

    private Long codigo;
    private String status;
    private BigDecimal valorAReceber;
    private BigDecimal diferencaValor;
    private BigDecimal valorRecebido;
}
