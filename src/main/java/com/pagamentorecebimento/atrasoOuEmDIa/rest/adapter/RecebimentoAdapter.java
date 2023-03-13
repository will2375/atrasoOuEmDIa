package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.factory.RecebimentoFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecebimentoAdapter {

    public RecebimentoResponse response(RecebimentosModel model) {
        final RecebimentoResponse response = RecebimentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAReceber(model.getValorAReceber())
                .diferencaValor(model.getDiferencaValor())
                .valorRecebido(model.getValorRecebido()).build();
        return response;
    }

    public RecebimentosModel calcularRecebimento(RecebimentoRest rest) {
        final RecebimentosModel model = RecebimentoFactory.criar(rest);

        return model;
    }
}
