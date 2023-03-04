package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.factory.RecebimentoFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.port.RecebimentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecebimentoAdapter {
    final RecebimentoPort port;

    public RecebimentoResponse converterRecebimento(RecebimentoRest rest) {
        final RecebimentosModel model = RecebimentoFactory.criar(rest);
        port.converterRecebimento(model);
        return RecebimentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .diferencaValor(model.getDiferencaValor())
                .valorAReceber(model.getValorAReceber())
                .valorRecebido(model.getValorRecebido()).build();
    }
}
