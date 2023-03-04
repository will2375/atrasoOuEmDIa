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
public class RecebimentoAdapter implements RecebimentoPort{

    @Override
    public RecebimentoResponse converterRecebimento(RecebimentoRest rest) {
        final RecebimentosModel model = RecebimentosModel.builder()
                .codigo(rest.getCodigo())
                .status(rest.getStatus())
                .diferencaValor(rest.getDiferencaValor())
                .valorAReceber(rest.getValorAReceber())
                .valorRecebido(rest.getValorRecebido()).build();
        return RecebimentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .diferencaValor(model.getDiferencaValor())
                .valorAReceber(model.getValorAReceber())
                .valorRecebido(model.getValorRecebido()).build();
    }
}
