package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;

import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.factory.RecebimentoFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.RecebimentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.port.RecebimentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RecebimentoAdapter implements RecebimentoPort{

    @Override
    public RecebimentoResponse converterRecebimento(RecebimentosModel model) {
        final RecebimentoResponse response = RecebimentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAReceber(model.getValorAReceber())
                .diferencaValor(model.getDiferencaValor())
                .valorRecebido(model.getValorRecebido()).build();
        return response;
    }

    public RecebimentosModel calcularRecebimento(RecebimentoRest rest) {
        final RecebimentosModel model = RecebimentosModel.builder()
                .codigo(rest.getCodigo())
                .status(rest.getStatus())
                .valorAReceber(rest.getValorAReceber())
                .diferencaValor(rest.getDiferencaValor())
                .valorRecebido(rest.getValorRecebido()).build();
        return model;
    }
}
