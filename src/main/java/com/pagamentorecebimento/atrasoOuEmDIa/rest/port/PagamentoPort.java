package com.pagamentorecebimento.atrasoOuEmDIa.rest.port;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import com.pagamentorecebimento.atrasoOuEmDIa.rest.model.response.PagamentoResponse;

public interface PagamentoPort {
     PagamentoResponse converterPagamento(PagamentosModel model);
}
