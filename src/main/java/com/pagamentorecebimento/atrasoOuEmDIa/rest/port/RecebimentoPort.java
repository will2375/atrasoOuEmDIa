package com.pagamentorecebimento.atrasoOuEmDIa.rest.port;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;

public interface RecebimentoPort {
    void converterRecebimento(RecebimentosModel model);
}
