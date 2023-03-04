package com.pagamentorecebimento.atrasoOuEmDIa.domain.formaspagamento;

import java.math.BigDecimal;

public interface Pagamentos {

    BigDecimal calculoPagamento(BigDecimal valorAPagar, BigDecimal diferenca);
}
