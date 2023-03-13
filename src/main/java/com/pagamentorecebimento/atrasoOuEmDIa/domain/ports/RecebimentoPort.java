package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;

import java.util.List;

public interface RecebimentoPort {
    RecebimentosModel cadastrarRecebimento(RecebimentosModel model);

    List<RecebimentoResponse> buscarRecebimentos(String status);

    List<RecebimentoResponse> listaRecebimentos();
}
