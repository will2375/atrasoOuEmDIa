package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;

public interface RecebimentoPort {
    RecebimentoResponse converterRecebimento(RecebimentosModel model);
}
