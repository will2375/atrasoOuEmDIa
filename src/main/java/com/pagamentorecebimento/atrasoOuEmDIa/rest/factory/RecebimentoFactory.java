package com.pagamentorecebimento.atrasoOuEmDIa.rest.factory;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.RecebimentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.RecebimentoRest;
import org.springframework.stereotype.Component;

@Component
public class RecebimentoFactory {
    public static RecebimentosModel
    criar(RecebimentoRest rest) {
      return RecebimentosModel.builder()
                .codigo(rest.getCodigo())
                .status(rest.getStatus())
                .valorRecebido(rest.getValorRecebido())
                .valorAReceber(rest.getValorAReceber())
                .diferencaValor(rest.getDiferencaValor()).build();

    }
}