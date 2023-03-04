package com.pagamentorecebimento.atrasoOuEmDIa.rest.port;


import com.pagamentorecebimento.atrasoOuEmDIa.domain.model.PagamentosModel;
import org.springframework.stereotype.Component;

@Component
public interface PagamentoPort {
    void converterPagamento(PagamentosModel model);
}
