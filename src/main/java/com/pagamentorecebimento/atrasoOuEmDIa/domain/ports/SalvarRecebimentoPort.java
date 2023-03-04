package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;

public interface SalvarRecebimentoPort {
    void salvarRecebimento(RecebimentosModel model);
}
