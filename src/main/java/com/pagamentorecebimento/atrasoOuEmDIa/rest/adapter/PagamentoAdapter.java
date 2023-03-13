package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.factory.PagamentoFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PagamentoAdapter {


    public PagamentosModel converterPagamento(PagamentoRest rest) {
        final PagamentosModel model = PagamentoFactory.criar(rest);
        return model;
    }


    public PagamentoResponse response(PagamentosModel model) {
        final PagamentoResponse response = PagamentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAPagar(model.getValorAPagar())
                .diferencaValor(model.getDiferencaValor())
                .valorPago(model.getValorPago()).build();
        return response;
    }
}
