package com.pagamentorecebimento.atrasoOuEmDIa.domain.ports;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;

public interface SalvarPagamentoPort {
    void salvarPagamento(PagamentosModel model);
}
