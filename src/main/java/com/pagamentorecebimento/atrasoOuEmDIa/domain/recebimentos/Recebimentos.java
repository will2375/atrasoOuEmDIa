package com.pagamentorecebimento.atrasoOuEmDIa.domain.recebimentos;

import java.math.BigDecimal;

public interface Recebimentos {

    BigDecimal calcularDesconto(BigDecimal valor);

    BigDecimal calculoFinal(BigDecimal valor, BigDecimal desconto);
}
