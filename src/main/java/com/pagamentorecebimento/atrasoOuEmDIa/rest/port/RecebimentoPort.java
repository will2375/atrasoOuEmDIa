package com.pagamentorecebimento.atrasoOuEmDIa.rest.port;

import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;

public interface RecebimentoPort {
    public RecebimentoResponse converterRecebimento(RecebimentoRest rest);
}
