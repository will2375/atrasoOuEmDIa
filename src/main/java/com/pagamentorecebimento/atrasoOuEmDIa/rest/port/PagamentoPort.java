package com.pagamentorecebimento.atrasoOuEmDIa.rest.port;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;

public interface PagamentoPort {
    void converterPagamento(PagamentosModel model);
}
