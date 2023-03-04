package com.pagamentorecebimento.atrasoOuEmDIa.rest.factory;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;
import org.springframework.stereotype.Component;

@Component
public class PagamentoFactory {

    public static PagamentosModel
    criar(PagamentoRest rest) {
        return PagamentosModel.builder()
                .codigo(rest.getCodigo())
                .status(rest.getStatus())
                .diferencaValor(rest.getDiferencaValor())
                .valorAPagar(rest.getValorAPagar())
                .valorPago(rest.getValorPago()).build();
    }
}
