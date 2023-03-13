package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.entrada.PagamentoRest;

public interface PagamentoPort {
     PagamentosModel converterPagamento(PagamentoRest rest);
}
