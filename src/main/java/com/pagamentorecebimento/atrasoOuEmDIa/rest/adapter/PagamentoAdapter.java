package com.pagamentorecebimento.atrasoOuEmDIa.rest.adapter;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.factory.PagamentoFactory;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.port.PagamentoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PagamentoAdapter {
    final PagamentoPort port;

    public PagamentoResponse converterPagamento(PagamentoRest rest){
        final PagamentosModel model = PagamentoFactory.criar(rest);
        port.converterPagamento(model);
        return PagamentoResponse.builder()
                .codigo(model.getCodigo())
                .status(model.getStatus())
                .diferencaValor(model.getDiferencaValor())
                .valorAPagar(model.getValorAPagar())
                .valorPago(model.getValorPago()).build();
    }

}
