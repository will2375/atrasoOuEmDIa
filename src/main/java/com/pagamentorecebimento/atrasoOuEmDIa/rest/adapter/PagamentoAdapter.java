package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.port.PagamentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PagamentoAdapter implements PagamentoPort {

    @Override
    public PagamentoResponse converterPagamento(PagamentosModel model) {
        final PagamentoResponse response = PagamentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .valorAPagar(model.getValorAPagar())
                .diferencaValor(model.getDiferencaValor())
                .valorPago(model.getValorPago()).build();

        return response;
    }

    public PagamentosModel calcularPagamento(PagamentoRest rest) {
        final PagamentosModel model = PagamentosModel.builder()
                .codigo(rest.getCodigo())
                .status(rest.getStatus())
                .valorAPagar(rest.getValorAPagar())
                .diferencaValor(rest.getDiferencaValor())
                .valorPago(rest.getValorPago()).build();
        return model;
    }
}
